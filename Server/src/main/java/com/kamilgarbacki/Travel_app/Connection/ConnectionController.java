package com.kamilgarbacki.Travel_app.Connection;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/connection")
@RequiredArgsConstructor
public class ConnectionController {

    private final ConnectionService connectionService;

    @GetMapping
    public List<Connection> getAllConnections(){
        return connectionService.getAllConnections();
    }

    @PostMapping
    public void addConnection(@RequestBody NewConnectionRequest request){
        connectionService.addConnection(request);
    }

    @DeleteMapping("/{connectionId}")
    public void deleteConnection(@PathVariable("connectionId") Long connectionId){
        connectionService.deleteConnection(connectionId);
    }

    @PatchMapping("/{connectionId}")
    public void updateConnection(@PathVariable("connectionId") Long connectionId,
                                 @RequestBody NewConnectionRequest request){
        connectionService.updateConnection(connectionId, request);
    }

    @GetMapping("/id/{connectionId}")
    public Connection getConnection(@PathVariable("connectionId") Long connectionId){
        return connectionService.getConnection(connectionId);
    }

    @GetMapping("/stations/{departureId}/{destinationId}")
    public List<Connection> getConnectionByDepartureAndDestination(@PathVariable("departureId") Long departureId,
                                                                   @PathVariable("destinationId") Long destinationId){
        return connectionService.getConnectionByDepartureAndDestination(departureId, destinationId);
    }
}
