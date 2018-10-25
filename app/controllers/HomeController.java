package controllers;

import play.mvc.*;
import com.fasterxml.jackson.databind.JsonNode;
import play.*;
import java.util.*;
import models.*;
import play.data.DynamicForm;
import play.data.Form;
import play.data.FormFactory;
import javax.inject.Inject;
import java.util.List;

import org.mongodb.morphia.query.Query;

import com.fasterxml.jackson.databind.JsonNode;
import com.mongodb.util.JSON;

import models.Person;
import play.*;
import play.data.Form;
import play.libs.Json;
/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(views.html.index.render());
    }

    public Result login() { return ok(views.html.login.render()); }

    private final FormFactory formFactory;

    @Inject
    public HomeController(final FormFactory formFactory){
        this.formFactory=formFactory;
    }
    public Result loginPost(){
        DynamicForm requestData = formFactory.form().bindFromRequest();
        String username = requestData.get("username");
        String password = requestData.get("password");
        String Loginbutton=requestData.get("Login");
        String Registerbutton=requestData.get("Register");

        String result;
        if(username.equals("play") && password.equals("123456"))
        {
            return ok(views.html.search.render());
        }
        else {
            return ok(views.html.register.render());
        }
    }

    public Result register() {
        Person person = new Person();
        person = Form.form(Person.class).bindFromRequest().get();
        person.save();
        return ok();
    }

    public Result search() { return ok(views.html.search.render()); }
}
