package ASOserver.model;

import java.util.ArrayList;
import java.util.List;

public class ChoiceList {

    private enum AccessRights {

        CUSTOMER("klient"),
        ADMINISTRATOR("administrator"),
        EMPLOYEE("pracownik");
        private String accessRights;

        private AccessRights(String accessRights) {
            this.accessRights = accessRights;
        }

        public String getAccessRights() {
            return accessRights;
        }
    }

    public List<String> getAccessRightsList(){
        List<String> accessRightsList = new ArrayList<>();
        AccessRights[] accessRights = AccessRights.values();
        for (AccessRights accessRight : accessRights) {
            accessRightsList.add(accessRight.getAccessRights());
        }
        return accessRightsList;
    }

    private enum NotyficationTypes {

        NOTIFICATION("powiadomienie"),
        REMINDER("przypomnienie"),
        DEMAND("wezwanie");
        private String notyficationTypes;

        private NotyficationTypes(String notyficationTypes) {
            this.notyficationTypes = notyficationTypes;
        }

        public String getNotyficationTypes() {
            return notyficationTypes;
        }
    }

    public List<String> getNotyficationTypes() {
        List<String> notyficationTypesList = new ArrayList<>();
        NotyficationTypes[] notyficationTypes = NotyficationTypes.values();
        for (NotyficationTypes notyficationType : notyficationTypes) {
            notyficationTypesList.add(notyficationType.getNotyficationTypes());
        }
        return notyficationTypesList;
    }

    private enum SpecificServicesExecutionStatus {

        NEW("nowa"),
        DOWNLOADED("pobrana"),
        DURING("w toku"),
        TERMINATED("rozwiązana"),
        FINISHED("zakończona");

        private String specificServicesExecutionStatus;

        private SpecificServicesExecutionStatus(String specificServicesExecutionStatus) {
            this.specificServicesExecutionStatus = specificServicesExecutionStatus;
        }

        public String getSpecificServicesExecutionStatus() {
            return specificServicesExecutionStatus;
        }
    }

    public List<String> getSpecificServicesExecutionStatus() {
        List<String> specificServicesExecutionStatusList = new ArrayList<>();
        SpecificServicesExecutionStatus[] specificServicesExecutionStatus = SpecificServicesExecutionStatus.values();
        for (SpecificServicesExecutionStatus specificServicesExecutionS : specificServicesExecutionStatus) {
            specificServicesExecutionStatusList.add(specificServicesExecutionS.getSpecificServicesExecutionStatus());
        }
        return specificServicesExecutionStatusList;
    }

    private enum PaymentMethod {

        CARD("karta"),
        CASH("gotówka"),
        TRANSFER("przelew");

        private String paymentMethod;

        private PaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
        }

        public String getPaymentMethod() {
            return paymentMethod;
        }
    }

    public List<String> getPaymentMethod() {
        List<String> paymentMethodList = new ArrayList<>();
        PaymentMethod[] paymentMethods = PaymentMethod.values();
        for (PaymentMethod paymentMethod : paymentMethods) {
            paymentMethodList.add(paymentMethod.getPaymentMethod());
        }
        return paymentMethodList;
    }

    private enum ServiceTypes {

        EXCHANGE("wymiana"),
        OVERVIEW("przegląd"),
        ANALYSIS("analiza"),
        REPAIR("naprawa");

        private String serviceTypes;

        private ServiceTypes(String serviceTypes) {
            this.serviceTypes = serviceTypes;
        }

        public String getServiceTypes() {
            return serviceTypes;
        }
    }

    public List<String> getServiceTypes() {
        List<String> serviceTypesList = new ArrayList<>();
        ServiceTypes[] serviceTypes = ServiceTypes.values();
        for (ServiceTypes serviceType : serviceTypes) {
            serviceTypesList.add(serviceType.getServiceTypes());
        }
        return serviceTypesList;
    }
}
