<template>
  <div class="card">
    <div class="left">
      <Level-Icon v-bind="{ icon, title }" active />
    </div>
    <div class="right">
      <div class="right__title">
        <strong>Meu Din Din!</strong>
        <div class="coin">
          <q-icon name="monetization_on" size="16px" />
          <strong>540</strong>
        </div>
      </div>
      <div class="bar"></div>
      <div class="bar2"></div>
      <div class="right__title">
        <strong>0</strong>
        <strong>700</strong>
      </div>
    </div>
  </div>
</template>

<script>
import LevelIcon from "./LevelIcon";

export default {
  name: "ProgressCard",
  components: {
    LevelIcon
  },
  props: {
    icon: String,
    title: String
  }
};
</script>

<style lang="scss" scoped>
.card {
  display: flex;
  justify-content: flex-start;
}

.right {
  margin-left: 16px;
  display: flex;
  flex: 1;
  flex-direction: column;
  justify-content: flex-start;
  align-content: flex-start;
}

.right__title {
  display: flex;
  justify-content: space-between;
  padding-bottom: 8px;
}

.coin {
  color: #ffc542;
}

.bar {
  background: #ffc542;
  border-radius: 6px;
  width: 70%;
  height: 8px;
}
</style>
