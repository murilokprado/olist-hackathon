<template>
  <div :class="{ 'not-active': !active }">
    <div class="icon">
      <q-icon :name="icon" size="md" color="white" />
    </div>
    <span class="title">{{ title }}</span>
  </div>
</template>

<script>
export default {
  name: "LevelIcon",
  props: {
    icon: String,
    title: String,
    active: Boolean
  }
};
</script>

<style lang="scss" scoped>
.not-active {
  .icon {
    opacity: 0.3;
  }

  .title {
    opacity: 0.3;
  }
}

.icon {
  background: #ffc542;
  border-radius: 12px;
  width: 59px;
  height: 59px;
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 16px;
}

.title {
  display: flex;
  padding-top: 4px;
  padding-left: 10px;
  font-size: 14px;
}
</style>
