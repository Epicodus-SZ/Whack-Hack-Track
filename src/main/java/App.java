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
    Member default1 = new Member("steve@zaske.com");
    Member default2 = new Member("billg@microsoft.com");


    //list all members
    get("members", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("members", Member.getAll());
      model.put("template", "templates/members.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


  }
}
