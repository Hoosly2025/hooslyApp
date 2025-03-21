package hooslyapp

import grails.gorm.services.Service

@Service(CustomerOnboardingMaintenanceFrequency)
interface CustomerOnboardingMaintenanceFrequencyService {

    CustomerOnboardingMaintenanceFrequency get(Serializable id)

    List<CustomerOnboardingMaintenanceFrequency> list(Map args)

    Long count()

    void delete(Serializable id)

    CustomerOnboardingMaintenanceFrequency save(CustomerOnboardingMaintenanceFrequency customerOnboardingMaintenanceFrequency)

}