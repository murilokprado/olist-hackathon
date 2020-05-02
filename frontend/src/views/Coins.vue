<template>
  <div class="coins">
    <div class="coins__card">
      <Progress-Card icon="monetization_on" title="Nível 1" />
    </div>
    <div class="coins__level">
      <Level-Icon
        class="coins__level-item"
        icon="monetization_on"
        title="Nível 1"
        active
      />
      <Level-Icon
        class="coins__level-item"
        icon="directions_bike"
        title="Nível 2"
      />
      <Level-Icon
        class="coins__level-item"
        icon="directions_car"
        title="Nível 3"
      />
      <Level-Icon
        class="coins__level-item"
        icon="flight_takeoff"
        title="Nível 4"
      />
    </div>
  </div>
</template>

<script>
import ProgressCard from "@/components/ProgressCard";
import LevelIcon from "@/components/LevelIcon";

export default {
  name: "Coins",
  components: {
    ProgressCard,
    LevelIcon
  }
};
</script>

<style lang="scss" scoped>
h3 {
  margin: 0;
}

.coins {
  padding: 32px;
}

.coins__card {
  background: #30444e;
  box-shadow: 0px 1px 14px #19282f;
  border-radius: 25px;
  padding: 24px;
}

.coins__level {
  display: flex;
  padding: 16px 0;
}

.coins__level-item {
  margin: 8px;
}
</style>
