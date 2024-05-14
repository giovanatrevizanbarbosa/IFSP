package br.edu.ifsp.arq.web1.ifitness.model.util.activity;

import br.edu.ifsp.arq.web1.ifitness.model.ActivityType;
import br.edu.ifsp.arq.web1.ifitness.model.User;

import java.time.LocalDate;

public class ActivitiesFilter {
    private User user;
    private ActivityType type;
    private LocalDate initialDate;
    private LocalDate finalDate;

    public LocalDate getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(LocalDate finalDate) {
        this.finalDate = finalDate;
    }

    public LocalDate getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(LocalDate initialDate) {
        this.initialDate = initialDate;
    }

    public ActivityType getType() {
        return type;
    }

    public void setType(ActivityType type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
