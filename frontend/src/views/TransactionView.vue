<template>
  <div class="transaction-container">
    <div class="transaction-header">
      <h5>Extrato dos Agendamentos Cadastrados</h5>
      <TransactionCreate />
    </div>
    <TransactionList />
  </div>
</template>

<script setup>
import TransactionCreate from '@/components/transaction/TransactionCreate.vue';
import TransactionList from '@/components/transaction/TransactionList.vue';
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
