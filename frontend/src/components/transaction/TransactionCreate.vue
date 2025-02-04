<template>
  <!-- Modal Trigger -->
  <a class="waves-effect waves-light btn modal-trigger" href="#modalTransaction">Adicionar</a>

  <!-- Modal Structure -->
  <div id="modalTransaction" class="modal" ref="modal">
    <div class="modal-content">
      <h5>Nova Transferência</h5>
      <p>Preencha os dados abaixo para realizar uma nova transferência.</p>

      <form>
        <div class="input-field col s12 l6">
          <select v-model="transaction.originAccount" ref="originAccountSelect">
            <option value="" disabled selected>Selecione uma opção</option>
            <option v-for="account in accounts" :key="account.accountId" :value="account.accountNumber">
              {{ account.accountNumber }}
            </option>
          </select>
          <label>Conta de Origem</label>
        </div>
        <div class="input-field col s12 l6">
          <select v-model="transaction.destinationAccount" ref="destinationAccountSelect">
            <option value="" disabled selected>Selecione uma opção</option>
            <option v-for="account in accounts" :key="account.accountId" :value="account.accountNumber">
              {{ account.accountNumber }}
            </option>
          </select>
          <label>Conta de Destino</label>
        </div>
        <div class="input-field col s12">
          <input type="number" id="amount" class="validate" min="0.01" step="any" required v-model="transaction.amount">
          <label for="amount" data-error="wrong" data-success="right">Valor da transferência (R$)</label>
        </div>
        <div class="input-field col s12">
          <input type="date" id="transfer_date" class="validate" v-model="transaction.transferDate">
          <label for="transfer_date" data-error="wrong" data-success="right">Data da transferência</label>
        </div>
      </form>
    </div>
    <div class="modal-footer">
      <a href="#!" class="modal-action modal-close waves-effect waves-red btn-flat">Cancelar</a>
      <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat"
        @click.prevent="saveTransaction()">Salvar</a>
    </div>
  </div>
</template>

<script>
import TransactionService from '@/services/TransactionService';
import AccountService from '@/services/AccountService';
import M from 'materialize-css';

export default {
  emits: ['transaction-created'],
  data() {
    return {
      modal: null,
      accounts: [],
      transaction: { originAccount: null, destinationAccount: null, amount: '', transferDate: ''}
    }
  },
  mounted() {
    this.$nextTick(() => this.modal = M.Modal.init(this.$refs.modal));
    this.loadAccountsOnSelect();
  },
  methods: {
    loadAccountsOnSelect() {
      return AccountService.getAccounts().then((response) => {
        this.accounts = response.data;
        this.$nextTick(() => {
          M.FormSelect.init(this.$refs.originAccountSelect)
          M.FormSelect.init(this.$refs.destinationAccountSelect)
        });
      });
    },
    saveTransaction() {
      TransactionService.addTransaction(this.transaction)
        .then((response) => {
          M.toast({ html: 'Transferência agendada com sucesso!', classes: 'green' })
          this.$emit('transaction-created', response.data);
          this.transaction = { originAccount: null, destinationAccount: null, amount: '', transferDate: '' };
          this.modal.close();
        },
          (error) => {
            let errorMessage = 'Erro ao agendar transferência.';
            if (error.response && error.response.data && error.response.data.message) {
              errorMessage = error.response.data.message;
            }
            M.toast({ html: errorMessage, classes: 'red' });
          }
        )
    }
  }
}
</script>

<style>
.modal,
.modal .modal-footer {
  background-color: var(--color-background);
}

.modal .modal-footer a {
  color: var(--color-text);
}

form {
  margin-top: 2rem;
}

.select-wrapper input.select-dropdown,
input[type="date"],
input[type="number"] {
  color: var(--color-text);
}

input[type="date"]::-webkit-calendar-picker-indicator {
  filter: invert(0.5);
}

</style>