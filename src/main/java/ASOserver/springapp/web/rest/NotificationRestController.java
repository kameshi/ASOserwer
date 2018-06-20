package ASOserver.springapp.web.rest;

import ASOserver.springapp.dto.NotificationDTO;
import ASOserver.springapp.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Scope("request")
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/aso/rest/notifications")
public class NotificationRestController {
    private final NotificationService notificationService;

    @Autowired
    public NotificationRestController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping()
    private ResponseEntity getNotifications(){
        try {
            List<NotificationDTO> notificationDTOList = this.notificationService.findNotifications();
            return new ResponseEntity(notificationDTOList, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    private ResponseEntity insertNotification(@RequestBody NotificationDTO NotificationDTO){
        try {
            this.notificationService.insertNotification(NotificationDTO);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{notificationId}")
    private ResponseEntity findNotification(@PathVariable Long notificationId) {
        try {
            NotificationDTO NotificationDTO = notificationService.findNotificationById(notificationId);
            return new ResponseEntity(NotificationDTO, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping(value = "/{notificationId}")
    private ResponseEntity updateNotification(@PathVariable Long notificationId, @RequestBody NotificationDTO notificationDTO) {
        try {
            notificationService.updateNotification(notificationId, notificationDTO);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{notificationId}")
    private ResponseEntity deleteNotification(@PathVariable Long notificationId) {
        try {
            notificationService.deleteNotification(notificationId);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
