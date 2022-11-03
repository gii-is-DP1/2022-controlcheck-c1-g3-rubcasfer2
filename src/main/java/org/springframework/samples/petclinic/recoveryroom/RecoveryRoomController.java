package org.springframework.samples.petclinic.recoveryroom;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/recoveryroom")
public class RecoveryRoomController {
    RecoveryRoomService recoveryRoomService;
    private static final String VIEW_FORM = "recoveryroom/createOrUpdateRecoveryRoomForm";
    @Autowired
    public RecoveryRoomController(RecoveryRoomService recoveryRoomService){
        this.recoveryRoomService = recoveryRoomService;
    }

    @GetMapping("/create")
    public ModelAndView showRecoveryRoomForm(){
        ModelAndView mav = new ModelAndView(VIEW_FORM);
        mav.addObject("recoveryRoom", new RecoveryRoom());
        return mav;

    }

    @PostMapping("/create")
public ModelAndView postRecoveryRoom(@Valid RecoveryRoom recoveryRoom, BindingResult br) throws DuplicatedRoomNameException {
    ModelAndView mav;
    if(br.hasErrors()){
        mav = new ModelAndView(VIEW_FORM);
        mav.addObject("recoveryRoom",recoveryRoom);
       
    }else{
       this.recoveryRoomService.save(recoveryRoom);
        mav = new ModelAndView("welcome");
       
    }
    return mav;
}
}
