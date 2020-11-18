package controller;

import service.user.AuthenticationService;
import view.AdministratorView;

public class AdministratorController {

    private final AuthenticationService authenticationService;
    private final AdministratorView administratorView;

    public AdministratorController(AuthenticationService authenticationService, AdministratorView administratorView) {
        this.authenticationService = authenticationService;
        this.administratorView = administratorView;

    }
}
