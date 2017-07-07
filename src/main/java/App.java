import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.Map;
import java.util.HashMap;

public class App {
  public static void main(String[] args) {
    //sets the default file location
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    //Add dummy default data
    Team testTeam1 = new Team("The Justice League");
    Team testTeam2 = new Team("The Avengers");
    Team testTeam3 = new Team("Suicide Squad");
    Member default1 = new Member("batman@dc.com");
    Member default2 = new Member("CaptAmerica@marvel.com");
    Member default3 = new Member("hulk@marvel.com");
    Member default4 = new Member("superman@dc.com");
    testTeam1.addMember(default1);
    testTeam1.addMember(default4);
    testTeam2.addMember(default2);
    testTeam2.addMember(default3);

    //list all members
    get("/members", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("members", Member.getAll());
      model.put("template", "templates/members.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/members/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/members-new.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/members/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String memberEmail = request.queryParams("email");
      Member member = new Member(memberEmail);
      model.put("members", Member.getAll());
      model.put("template", "templates/members.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //list all teams
    get("/teams", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("teams", Team.getAll());
      model.put("template", "templates/teams.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/teams/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/teams-new.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/teams/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Team team = Team.find(Integer.parseInt(request.params(":id")));
      model.put("team", team);
      model.put("template", "templates/team.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/teams/:id/assign", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Team team = Team.find(Integer.parseInt(request.params(":id")));
      model.put("members", Member.getAll());
      model.put("team", team);
      model.put("template", "templates/assign.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/teams/:id/assign", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Team team = Team.find(Integer.parseInt(request.params(":id")));
      model.put("team", team);
      team.clearMembers();
      for (String memID : request.queryParams()){
        Member member = Member.find(Integer.parseInt(memID));
        team.addMember(member);
      }
      model.put("template", "templates/team.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/teams/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String teamName = request.queryParams("teamName");
      Team team = new Team(teamName);
      model.put("teams", Team.getAll());
      model.put("template", "templates/teams.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());



  } //end of main
} //end of App class
