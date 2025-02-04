<template>
  <div class="account-container">
    <div class="account-header">
      <h5>Contas Cadastradas</h5>
      <AccountCreate @account-created="updateAccountList" />
    </div>
    <AccountList ref="accountList" />
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import AccountList from '@/components/account/AccountList.vue';
import AccountCreate from '@/components/account/AccountCreate.vue';

const accountList = ref(null);

const updateAccountList = (newAccount) => { // Recebe os dados da nova conta
  accountList.value.loadAccounts();
};
</script>

<style>
@media (min-width: 1024px) {
  .account, .account-header {
    display: flex;
    align-items: center;
  }

  .account-header {
    justify-content: space-between;
  }

  h5 {
    color: var(--color-heading);
  }
}
</style>
