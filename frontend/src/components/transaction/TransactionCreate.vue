<template>
  <!-- Modal Trigger -->
  <a class="waves-effect waves-light btn modal-trigger" href="#modalTransaction">Adicionar</a>
  
  <!-- Modal Structure -->
  <div id="modalTransaction" class="modal">
    <div class="modal-content">
      <h5>Nova Transferência</h5>
      <p>Preencha os dados abaixo para realizar uma nova transferência.</p>

      <form action="">
        <div class="input-field col s12 l6">
          <input type="text" id="origin_account" class="validate">
          <label for="origin_account">Conta de origem</label>
        </div>
        <div class="input-field col s12 l6">
          <input type="text" id="destination_account" class="validate">
          <label for="destination_account">Conta de destino</label>
        </div>
        <div class="input-field col s12">
          <input type="text" id="fee" class="validate">
          <label for="fee" data-error="wrong" data-success="right">Taxa (R$)</label>
        </div>
        <div class="input-field col s12">
          <input type="text" id="amount" class="validate">
          <label for="amount" data-error="wrong" data-success="right">Valor da transferência (R$)</label>
        </div>
        <div class="input-field col s12">
          <input type="date" id="transfer_date" class="validate">
          <label for="transfer_date" data-error="wrong" data-success="right">Data da transferência</label>
        </div>
      </form>
    </div>
    <div class="modal-footer">
      <a href="#!" class=" modal-action modal-close waves-effect waves-red btn-flat">Cancelar</a>
      <a href="#!" class=" modal-action modal-close waves-effect waves-green btn-flat">Salvar</a>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      modal: null,
    }
  },
  mounted() {
    this.modal = M.Modal.init(document.getElementById('modalTransaction'));
  }
}
</script>

<style>
.modal, .modal .modal-footer {
  background-color: var(--color-background);
}

.modal .modal-footer a {
  color: var(--color-text);
}

form {
  margin-top: 2rem;
}
</style>