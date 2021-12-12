import http from "../services/http-commons";

class SQLDataService {
    getAll() {
        return http.get("/sql/contacts")
    }

    get(id) {
        return http.get(`/sql/contacts/${id}`)
    }

    create(data) {
        return http.post("/sql/contacts", data)
    }

    update(id, data) {
        return http.put(`/sql/contacts/${id}`, data)
    }

    delete(id) {
        return http.delete(`/sql/contacts/${id}`)
    }

    findByFirstName(firstName) {
        return http.get(`/sql/contacts/findByFirstName/${firstName}`)
    }

    findByLastName(lastName) {
        return http.get(`/sql/contacts/findByLastName/${lastName}`)
    }

    findByEmail(email) {
        return http.get(`/sql/contacts/findByEmail/${email}`)
    }

    findByPhoneNumber(phoneNumber) {
        return http.get(`/sql/contacts/findByPhoneNumber/${phoneNumber}`)
    }

    findByCompany(company) {
        return http.get(`/sql/contacts/findByCompany/${company}`)
    }

    findByDepartment(department) {
        return http.get(`/sql/contacts/findByDepartment/${department}`)
    }

    findByJobTitle(jobTitle) {
        return http.get(`/sql/contacts/findByJobTitle/${jobTitle}`)
    }
}

export default new SQLDataService();
