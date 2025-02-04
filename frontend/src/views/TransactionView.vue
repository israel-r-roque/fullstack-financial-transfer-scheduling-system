<template>
  <div class="transaction-container">
    <div class="transaction-header">
      <h5>Extrato dos Agendamentos Cadastrados</h5>
      <TransactionCreate @transaction-created="updatetransactionList" />
    </div>
    <TransactionList ref="transactionList" />
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import TransactionCreate from '@/components/transaction/TransactionCreate.vue';
import TransactionList from '@/components/transaction/TransactionList.vue';

const transactionList = ref(null);

const updatetransactionList = (newTransaction) => { 
  transactionList.value.loadTransactions();
};

</script>

<style>
@media (min-width: 1024px) {
  .transaction, .transaction-header {
    display: flex;
    align-items: center;
  }

  .transaction-header {
    justify-content: space-between;
  }

  h5 {
    color: var(--color-heading);
  }
}
</style>
