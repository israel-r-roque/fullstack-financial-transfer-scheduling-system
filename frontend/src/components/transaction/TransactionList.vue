<template>
  <table class="highlight">
    <thead>
      <tr>
        <th data-field="price">Conta de origem</th>
        <th data-field="name">Conta de destino</th>
        <th data-field="price">Taxa (R$)</th>
        <th data-field="price">Valor da transferência (R$)</th>
        <th data-field="id">Data da transferência</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>XPO123456</td>
        <td>ABC123456</td>
        <td>R$ 12,00</td>
        <td>R$ 1.012,00</td>
        <td>02/03/2025</td>
      </tr>
      <tr>
        <td>XPO123456</td>
        <td>ABC123456</td>
        <td>R$ 12,00</td>
        <td>R$ 1.012,00</td>
        <td>02/03/2025</td>
      </tr>
      <tr>
        <td>XPO123456</td>
        <td>ABC123456</td>
        <td>R$ 12,00</td>
        <td>R$ 1.012,00</td>
        <td>02/03/2025</td>
      </tr>
    </tbody>
  </table>
</template>

<style>
table {
  margin-top: 2rem;
}
table.highlight>tbody>tr:hover {
  background-color: var(--color-background-soft);
}
</style>