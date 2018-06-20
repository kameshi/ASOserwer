package ASOserver.springapp.dto;

import java.io.Serializable;

public class DashboardDTO implements Serializable {
    private long newServicesCount;
    private long activeServicesCount;
    private long finishedServicesCount;
    private long servicesCount;
    private long employeesCount;
    private long clientsCount;
    private long carsCount;

    public long getNewServicesCount() {
        return newServicesCount;
    }

    public void setNewServicesCount(long newServicesCount) {
        this.newServicesCount = newServicesCount;
    }

    public long getActiveServicesCount() {
        return activeServicesCount;
    }

    public void setActiveServicesCount(long activeServicesCount) {
        this.activeServicesCount = activeServicesCount;
    }

    public long getFinishedServicesCount() {
        return finishedServicesCount;
    }

    public void setFinishedServicesCount(long finishedServicesCount) {
        this.finishedServicesCount = finishedServicesCount;
    }

    public long getServicesCount() {
        return servicesCount;
    }

    public void setServicesCount(long servicesCount) {
        this.servicesCount = servicesCount;
    }

    public long getEmployeesCount() {
        return employeesCount;
    }

    public void setEmployeesCount(long employeesCount) {
        this.employeesCount = employeesCount;
    }

    public long getClientsCount() {
        return clientsCount;
    }

    public void setClientsCount(long clientsCount) {
        this.clientsCount = clientsCount;
    }

    public long getCarsCount() {
        return carsCount;
    }

    public void setCarsCount(long carsCount) {
        this.carsCount = carsCount;
    }
}
