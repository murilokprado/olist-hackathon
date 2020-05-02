<template>
  <div class="app-header">
    <div class="app-header__name">
      <strong>Loja do Marcão</strong>
    </div>
    <div class="app-header__icon">
      <q-icon name="notifications_active" size="sm" />
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
  justify-content: space-between;
  width: 100%;
  padding: 16px;
}

.app-header__name {
  display: flex;
  align-items: center;
  height: 100%;
  padding: 0 16px;
  font-size: 16px;
}

.app-header__icon {
  color: rgba(255, 255, 255, 0.6);
}
</style>
