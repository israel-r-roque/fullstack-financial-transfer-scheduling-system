import axios from "axios";

const API_BASE_URL = 'http://localhost:8080/api/v1/transactions';

export default {
    addTransaction(transaction) {
        return axios.post(API_BASE_URL, transaction);
    },
    getTransactions() {
        return axios.get(API_BASE_URL);
    }
}