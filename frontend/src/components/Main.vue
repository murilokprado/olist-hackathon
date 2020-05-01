<template>
  <div>
    <AppHeader />
    <q-tabs v-model="tab" no-caps class="">
      <q-tab name="geral" label="Geral" />
      <q-tab name="mensagens" label="Mensagens" />
      <q-tab name="coins" label="Olist Coins" />
    </q-tabs>
    <router-view />
  </div>
</template>

<script>
import AppHeader from "./AppHeader";

export default {
  name: "Main",
  components: {
    AppHeader
  },
  data() {
    return {
      tab: "geral"
    };
  }
};
</script>
