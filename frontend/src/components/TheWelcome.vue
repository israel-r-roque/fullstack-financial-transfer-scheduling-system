<script setup>
import WelcomeItem from './WelcomeItem.vue'
import IconAccountBalance from './icons/IconAccountBalance.vue'
import IconCurrencyExchange from './icons/IconCurrencyExchange.vue'
import IconDocumentation from './icons/IconDocumentation.vue'

</script>

<template>
  <WelcomeItem>
    <template #icon>
      <IconAccountBalance />
    </template>
    <template #heading>
      Contas
    </template>
    <template #description>
      Cadastre a sua conta para começar a usar nossos serviços.
    </template>
  </WelcomeItem>

  <WelcomeItem>
    <template #icon>
      <IconCurrencyExchange />
    </template>
    <template #heading>
      Transferências
    </template>
    <template #description>
      Realize uma transferência a qualquer momento, pagando a menor taxa do pais.
    </template>
  </WelcomeItem>

  <WelcomeItem>
    <template #icon>
      <IconDocumentation />
    </template>
    <template #heading>
      Documentação
    </template>
    <template #description>
      Veja como é simples e fácil utilizar nossa aplicação
    </template>
  </WelcomeItem>

</template>
