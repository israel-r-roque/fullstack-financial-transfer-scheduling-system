<template>
  <!-- Modal Trigger -->
  <a class="waves-effect waves-light btn modal-trigger" href="#modalAccount" ref="modalTrigger">Adicionar</a>

  <!-- Modal Structure -->
  <div id="modalAccount" class="modal" ref="modal">
    <div class="modal-content">
      <h5>Adicionar Conta</h5>
      <p>Preencha os dados abaixo para criar uma nova conta.</p>

      <form>
        <div class="input-field col s12 l6">
          <input type="text" id="account_number" class="validate" maxlength="10" v-model="account.accountNumber">
          <label for="account_number">Número da Conta</label>
        </div>
      </form>
    </div>
    <div class="modal-footer">
      <a href="#!" class="modal-action modal-close waves-effect waves-red btn-flat">Cancelar</a>
      <a @click.prevent="saveAccount()" href="#!"
        class="modal-action modal-close waves-effect waves-green btn-flat">Salvar</a>
    </div>
  </div>
</template>

<script>
import AccountService from '@/services/AccountService';

export default {
  emits: ['account-created'],
  data() {
    return {
      modal: null,
      account: {
        accountNumber: ''
      }
    }
  },
  mounted() {
    this.$nextTick(() => this.modal = M.Modal.init(this.$refs.modal));
  },
  methods: {
    saveAccount() {
      AccountService.addAccount(this.account).then(
        (response) => {
          M.toast({ html: 'Conta adicionada com sucesso!', classes: 'green' })
          this.$emit('account-created', response.data);
          this.account = { accountNumber: '' };
          this.modal.close();
        },
        (error) => {
          let errorMessage = 'Erro ao adicionar conta.';
          if (error.response && error.response.data && error.response.data.message) {
            errorMessage = error.response.data.message;
          }
          M.toast({ html: errorMessage, classes: 'red' });
        }
      );
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
</style>