import axios from "axios";

const API_BASE_URL = 'http://localhost:8080/api/v1/accounts';

export default {
    addAccount(account) {
        return axios.post(API_BASE_URL, account);
    },
    getAccounts() {
        return axios.get(API_BASE_URL);
    }
}