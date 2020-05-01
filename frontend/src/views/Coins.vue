<template>
  <div class="coins">
    <h3 class="coins__title">
      <q-icon name="attach_money" /> <strong>500</strong>
    </h3>
    <div class="coins__subtitle">
      <a>Trocar por vantagens</a>
      <a>Trocar por reais</a>
    </div>
  </div>
</template>

<script>
export default {
  name: "Coins"
};
</script>

<style lang="scss" scoped>
h3 {
  margin: 0;
}

.coins {
  padding: 32px;
}

.coins__title {
  align-items: center;
  display: flex;
  justify-content: center;
}

.coins__subtitle {
  align-items: center;
  display: flex;
  justify-content: center;
}

a {
  cursor: pointer;
  text-decoration: underline;
}

.coins__subtitle a:first-child {
  margin-right: 32px;
}
</style>
