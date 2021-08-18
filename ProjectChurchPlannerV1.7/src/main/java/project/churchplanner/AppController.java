/*
 * Spring MVC Controller class
 * AppController processes incoming REST API. This class allow Spring
 * to recognize it as RESTful service during the runtime
 * Controller layer used to simplify the handling of request and response from the client
 */
package project.churchplanner;

import java.sql.Date;
import java.util.ArrayList;
import project.churchplanner.member.Member;
import project.churchplanner.member.MemberService;
import project.churchplanner.activity.Activity;
import project.churchplanner.activity.ActivityService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import project.churchplanner.activity.ActivityRepository;
import project.churchplanner.member.MemberDetails;
import project.churchplanner.member.MemberRepository;

/**
 *
 * @author Ingrycht Antunes
 */
@Controller
public class AppController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private ActivityService activityService;

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private MemberRepository memberRepository;

    //reads the configuration from application.properties
    @Autowired(required = true)
    private JavaMailSender mailSender;


    /*
    This method retrive all of the information from the main page
    */
    @RequestMapping("/")
    public String viewHomePage(@AuthenticationPrincipal MemberDetails memberDetail,
            Model model) {
        //Variable to get the username that is logged in
        String username = memberDetail.getUsername();
        //pass the parameter to the calling method the retrieve the member's information
        Member member = memberService.getMemberByUsername(username);
        //add the retrieved information to the webpage
        model.addAttribute("user", member);

        AppController app = new AppController();
        //local variable to get the id for the member that is logged in
        Member memberID = memberService.getMemberByUsername(username);
        // System.out.println(memberID);

        //create a list of activities that this member is involved
        List<Activity> membersInvolved = activityService.findActivityByMemberID(memberID);
        //add the retrieved information to the webpage
        model.addAttribute("membersInvolved", membersInvolved);
        model.addAttribute("listMembers", memberService.listAll());

        return "index";
    }

    /**
     * AppController for all about Member Entity
     */
    
    
    //method responsible to add a ner member
    @RequestMapping("/newmember")
    public String showNewMemberForm(Model model) {
        Member member = new Member();
        model.addAttribute("member", member);

        return "new_member";
    }

    //method responsible to edit a member
    @RequestMapping("/editmember/{memberID}")
    public ModelAndView showEditMemberForm(@PathVariable(name = "memberID") Integer memberID) {
        ModelAndView mav = new ModelAndView("edit_member");

        Member member = memberService.get(memberID);
        mav.addObject("member", member);
        //System.out.println(member);

        return mav;
    }

    //method responsible to search a member by name
    @GetMapping("/search")
    @ResponseBody
    public ModelAndView getMemberByName(String keyword) {
        ModelAndView mav = new ModelAndView("index");
        List<Member> search = memberService.findByNameContainingIgnoreCase(keyword);

        mav.addObject("listMembers", search);
        return mav;

    }

    //method responsible to delete a member turning them disabled
    @RequestMapping("/deletemember/{memberID}")
    public String deleteMember(@PathVariable(name = "memberID") Integer memberID) {
        // System.out.println("before: "+ memberService.get(memberID).getEnabled());
        memberService.deleteMember(memberID);
        // System.out.println("after: " + memberService.get(memberID).getEnabled());
        memberService.save(memberService.get(memberID));
        return "redirect:/";
    }

    //method responsible to save the information after update,delete or new member
    @RequestMapping(value = "/save_member", method = {RequestMethod.POST, RequestMethod.PUT, RequestMethod.GET})
    public String saveMember(@ModelAttribute("member") Member member) {
        memberService.save(member);
        //return to the homePage
        return "redirect:/";
    }
    
    //method responsible ro retrieve all the members informations
    @ModelAttribute("members")
    public List<Member> members() {
        return memberRepository.findAll();
    }

    /**
     * AppController for all about Activity Entity
     */
    
    //method responsible to retrieve all of the activities in the database
    @RequestMapping("/activities")
    public String viewHomePageActivity(Model model) {
        List<Activity> listActivities = activityService.listAll();
        model.addAttribute("listActivities", listActivities);
        //System.out.println("Hello from viewHomePage");
        return "activities";
    }

    
    //Method responsible to edit activity
    @RequestMapping("/editactivity/{activityID}")
    //"/editactivity/{activityID}" is getting the members that are working on the activityID 1
    //it should get the activityID 1 not the members that are working on it
    @ResponseBody
    @ModelAttribute("activity")
    public ModelAndView showEditActivityForm(@PathVariable(name = "activityID") Integer activityID) {
        ModelAndView mav = new ModelAndView("edit_activity");

        Activity activity = activityService.get(activityID);
        System.out.println(activity);
        mav.addObject("activity", activity);
        return mav;
    }

    //method respinsible to delete the selected activity
    @RequestMapping("/deleteactivity/{activityID}")
    public String deleteActivity(@PathVariable(name = "memberID") Integer activityID) {
        memberService.delete(activityID);
        return "redirect:/";
    }

    //method responsible to add a new activity
    @RequestMapping(value = "/newactivity", method = {RequestMethod.POST, RequestMethod.PUT, RequestMethod.GET})
    public String showNewActivityForm(Model model) {
        Activity activity = new Activity();
        model.addAttribute("activity", activity);
        return "new_activity";
    }

    //method responsible the save information after update, delete or add new
    @RequestMapping(value = "/save_activity", method = {RequestMethod.POST, RequestMethod.PUT, RequestMethod.GET})
    public String saveActivity(@ModelAttribute("activity") Activity activity) {
        activityService.save(activity);
        //return to the homePage
        return "redirect:/activities";
    }

    //method responsible to retrieve the all activities
    @ModelAttribute("activities")
    public List<Activity> activities() {
        return activityRepository.findAll();
    }

    @ModelAttribute("calendar")
    public List<Activity> viewActivities() {
        return activityRepository.findAll();
    }

    //method responsible to search activity by date
    @GetMapping("/searchDate")
    @ResponseBody
    public ModelAndView getActivityByActivityDate(Date activitydate) {
        ModelAndView mav = new ModelAndView("index");
        //System.out.println(activitydate);
        List<Activity> search = activityService.findActivityByActivitydate(activitydate);

        mav.addObject("activities", search);
        return mav;
    }

    //confirmation of the emails have been sent to all of the members and return the activity list
    @GetMapping("/sendinvitation")
    public String sendInvitationForm() {
        return "send_invitation";
    }

    //send invitation by email for all of the members selected to a specific activity
    @PostMapping(value = "/contact/{sendEmail}")
    public String submitEmail(HttpServletRequest request, @PathVariable(name = "sendEmail") String name) {
        
        //System.out.println("name = " + name);
        
        //create an array to populate with the names by splitting it by comma separate 
        String[] splitName = name.split(",");
        
        //local variable arraylist to get all of the members fom the sliptted String
        List<Member> memberEmails = new ArrayList<>();
        
        //local variable to be assigned each name into the arralyList
        String nameSplited;
        
        //traverse the arraylist to find each member involved in the specific activity
        for (int i = 0; i < splitName.length; i++) {
            //System.out.println(splitName[i]);
            nameSplited = splitName[i];
            memberEmails.add(memberService.findByName(nameSplited));
           // memberEmails.add(memberService.findByName(splitName[i].));
        }

        
        //traverse the arraylist to send the email to each memeber
        for (Member email : memberEmails) {
            
            //System.out.println(email.getEmail());
            
            //email content
            String mailContent = "You were selected for a new activity."
                    + "\nCheck the church's website"
                    + "\n\nKind Regards"
                    + "\n\nChurch Planner";

            //email subject
            String mailSubject = "New activity added into your account from Church Planner";

            //variable to get the smtp information from the app properties and communicates via API
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("nci.churchplanner@gmail.com");
            message.setTo(email.getEmail());
            message.setSubject(mailSubject);
            message.setText(mailContent);

            mailSender.send(message);

        }
        return "send_invitation";

    }

    //if getting an error, a webpage will say about the error and the user can continue to use the web app
    @GetMapping("/403")
    public String error403() {
        return "403";
    }
}
