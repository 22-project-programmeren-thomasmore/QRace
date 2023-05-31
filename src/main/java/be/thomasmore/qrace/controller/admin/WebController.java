package be.thomasmore.qrace.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

  // @GetMapping({ "/", "/home" })
  // public String home() {
  // return "index";
  // }

  // @GetMapping("/race")
  // public String racePage() {
  // return "race";
  // }

  // @GetMapping("/highscore")
  // public String highscore() {
  // return "highscore";
  // }

  // @GetMapping({ "/name" })
  // public String name() {
  // return "name";
  // }

  // @GetMapping({ "/host-join" })
  // public String hostOrJoin() {
  // return "host-join";
  // }

  // @GetMapping({ "/host" })
  // public String pickMascotAsHost() {
  // return "host-pickMascot";
  // }

  // @GetMapping({ "/join" })
  // public String seeAvailableRaces() {
  // return "join-availableRaces";
  // }

  // @GetMapping({ "/join/pickMascot" })
  // public String pickMascotAsMember() {
  // return "join-pickMascot";
  // }

  // @GetMapping({ "/lobby" })
  // public String lobby() {
  // return "lobby";
  // }

  @GetMapping({ "/manageQuestions", "/managequestions", "/questions" })
  public String manageQuestions() {
    return "admin/manageQuestions";
  }
}
