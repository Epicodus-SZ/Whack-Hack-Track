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
    Team testTeam1 = new Team("Flogging Mollys");
    Team testTeam2 = new Team("Five Bunnys");
    Team testTeam3 = new Team("The Snacks Overflow");
    Member default1 = new Member("steve@zaske.com");
    Member default2 = new Member("billg@microsoft.com");
    testTeam2.addMember(default1);
    testTeam2.addMember(default2);

    //list all members
    get("members", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("members", Member.getAll());
      model.put("template", "templates/members.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //list all teams
    get("teams", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("teams", Team.getAll());
      model.put("template", "templates/teams.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/teams/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Team team = Team.find(Integer.parseInt(request.params(":id")));
      model.put("team", team);
      model.put("template", "templates/team.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  } //end of main
} //end of App class
