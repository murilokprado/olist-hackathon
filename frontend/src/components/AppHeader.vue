<template>
  <div class="app-header">
    <div class="app-header__name">
      <strong>Loja do Marcão</strong>
      <q-btn label="Teste" />
    </div>
  </div>
</template>

<script>
export default {
  name: "AppHeader"
};
</script>

<style lang="scss" scoped>
.app-header {
  align-items: center;
  display: flex;
  height: 55px;
  justify-content: center;
  width: 100%;
}

.app-header__name {
  border: 2px solid white;
  border-top: none;
  display: flex;
  align-items: center;
  height: 100%;
  padding: 0 16px;
}
</style>
