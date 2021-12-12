import http from "../services/http-commons";

class MongoDBDataService {
    getAll() {
        return http.get("/mongodb/contacts")
    }

    getContactById(id) {
        return http.get(`/mongodb/contacts/${id}`)
    }

    createContact(data) {
        return http.post("/mongodb/contacts", data)
    }

    createLogs(data) {
        return http.post("/mongodb/logs", data)
    }

    updateContact(id, data) {
        return http.put(`/mongodb/contacts/${id}`, data)
    }

    deleteContactById(id) {
        return http.delete(`/mongodb/contacts/${id}`)
    }

    findByFirstName(firstName) {
        return http.get(`/mongodb/contacts/findByFirstName/${firstName}`)
    }

    findByLastName(lastName) {
        return http.get(`/mongodb/contacts/findByLastName/${lastName}`)
    }

    findByEmail(email) {
        return http.get(`/mongodb/contacts/findByEmail/${email}`)
    }

    findByPhoneNumber(phoneNumber) {
        return http.get(`/mongodb/contacts/findByPhoneNumber/${phoneNumber}`)
    }

    findByCompany(company) {
        return http.get(`/mongodb/contacts/findByCompany/${company}`)
    }

    findByDepartment(department) {
        return http.get(`/mongodb/contacts/findByDepartment/${department}`)
    }

    findByJobTitle(jobTitle) {
        return http.get(`/mongodb/contacts/findByJobTitle/${jobTitle}`)
    }

    searchLogsById(id) {
        return http.get(`/mongodb/logs/${id}`)
    }

    searchLogsByUsername(username) {
        return http.get(`/mongodb/logs/searchLogsByUsername/${username}`)
    }

    deleteSearchLogsById(id) {
        return http.delete(`/mongodb/logs/deleteSearchLogsById/${id}`)
    }
}

export default new MongoDBDataService();