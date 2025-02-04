<template>
  <div v-if="accounts.length === 0" class="no-data">
    <p>Nenhuma conta cadastrada.</p>
  </div>
  <table v-else class="highlight">
    <thead>
      <tr>
        <th data-field="price">ID</th>
        <th data-field="price">Conta de origem</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="account in accounts" :key="account.accountId">
        <td>{{ account.accountId }}</td>
        <td>{{ account.accountNumber }}</td>
      </tr>
    </tbody>
  </table>
</template>

<script>
import AccountService from '@/services/AccountService';

export default {
  data() {
    return {
      accounts: []
    }
  },
  methods: {
    loadAccounts() {
      return AccountService.getAccounts().then((response) => {
        this.accounts = response.data;
      }).catch(error => {
        console.error("Erro ao carregar contas:", error); // Tratamento de erros
      });
    }
  },
  mounted() {
    this.loadAccounts()
    console.log(this.accounts);

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
</style>