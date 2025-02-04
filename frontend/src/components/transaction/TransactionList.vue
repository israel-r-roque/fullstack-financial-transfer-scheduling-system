<template>
  <div v-if="transactions.length === 0" class="no-data">
    <p>Nenhuma transferência agendada.</p>
  </div>
  <table v-else class="highlight">
    <thead>
      <tr>
        <th data-field="price">Conta de origem</th>
        <th data-field="name">Conta de destino</th>
        <th data-field="price">Valor da transferência</th>
        <th data-field="price">Taxa</th>
        <th data-field="id">Data da transferência</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="transaction in transactions" :key="transaction.id">
        <td>{{ transaction.originAccount }}</td>
        <td>{{ transaction.destinationAccount }}</td>
        <td>{{ formatCurrency(transaction.amount) }}</td>
        <td>{{ formatCurrency(transaction.fee) }}</td>
        <td>{{ formatDate(transaction.transferDate) }}</td>
      </tr>
    </tbody>
  </table>
</template>

<script>
import TransactionService from '@/services/TransactionService';

export default {
  data() {
    return {
      transactions: []
    }
  },
  methods: {
    loadTransactions() {
      return TransactionService.getTransactions().then((response) => {
        this.transactions = response.data;
      }).catch(error => {
        console.error("Erro ao carregar as transferências agendadas:", error);
      });
    },
    formatCurrency(value) {
      if (value) {
        return new Intl.NumberFormat('pt-BR', { style: 'currency', currency: 'BRL' }).format(value);
      }
      return 'R$ 0,00';
    },
    formatDate(dateString) {
      if (dateString) {
        const date = new Date(dateString);
        return date.toLocaleDateString('pt-BR');
      }
      return '';
    },
  },
  mounted() {
    this.loadTransactions();
  }
}
</script>

<style>
.no-data,
table {
  margin-top: 2rem;
}

table.highlight>tbody>tr:hover {
  background-color: var(--color-background-soft);
}

td {
  text-align: center;
}
</style>