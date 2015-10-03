<?xml version="1.0" encoding="UTF-8"?>
<de.fzi.power:PowerModelRepository xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:de.fzi.power="http://www.fzi.de/Power/Specification/1.0" id="_yakpMDnDEeSXp6PobgrWpg">
  <powerModelSpecifications xsi:type="de.fzi.power:ResourcePowerModelSpecification" id="_daqEMDgXEeSFuYf_V61WsQ" name="Linear Power Model">
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_vkR8ADgXEeS9Ksbwfez2QA" name="Idle Consumption"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_yosvQDgXEeS9Ksbwfez2QA" name="Maximum Consumption"/>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_2l6y0jnEEeSXp6PobgrWpg" name="Utilization">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricspec#_QIb6cikUEeSuf8LV7cHLgA"/>
    </consumptionFactors>
  </powerModelSpecifications>
  <powerModelSpecifications xsi:type="de.fzi.power:ResourcePowerModelSpecification" id="_daqEMDgXEeSFuYp_X61Wsr" name="Non-Linear Regression Power Model">
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_vkR8ADgXEeS9Ksbwfez3NA" name="Idle Consumption"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_yosvQDgXEeS9Ksbwfqy4NA" name="Maximum Consumption"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_yosvQDgZGeS9Ksbwfqy4NA" name="Exponent"/>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_2l6y0jnEEeSWp6PobgrW4NA" name="Utilization">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricspec#_QIb6cikUEeSuf8LV7cHLgA"/>
    </consumptionFactors>
  </powerModelSpecifications>
  <powerModelSpecifications xsi:type="de.fzi.power:ResourcePowerModelSpecification" id="_daqEMDgXEeSFuYp_X61Wxp" name="0.1*n Interpolation Model">
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_vkR8ADgXEeS9Ksbwfez3XP" name="Consumption at 0% Utilization"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_yosvQDgXEeS9Ksbwfqy4XP" name="Consumption at 10% Utilization"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_yosvQDgZGeS9Ksbwfqy4XP" name="Consumption at 20% Utilization"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_yosvQDgZGeS9Ksbwfqy5XP" name="Consumption at 30% Utilization"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_yosvQDgZGeS9Ksbwfqy6XP" name="Consumption at 40% Utilization"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_yosvQDgZGeS9Ksbwfqy7XP" name="Consumption at 50% Utilization"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_yosvQDgZGeS9Ksbwfqy8XP" name="Consumption at 60% Utilization"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_yosvQDgZGeS9Ksbwfqy9XP" name="Consumption at 70% Utilization"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_yosvQDgZGeS9Ksbwfqy10P" name="Consumption at 80% Utilization"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_yosvQDgZGeS9Ksbwfqy11P" name="Consumption at 90% Utilization"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_yosvQDgZGeS9Ksbwfqy12P" name="Consumption at 100% Utilization"/>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_2l6y0jnEEeSWp6PobgrW4XP" name="Utilization">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricspec#_QIb6cikUEeSuf8LV7cHLgA"/>
    </consumptionFactors>
  </powerModelSpecifications>
  <powerModelSpecifications xsi:type="de.fzi.power:DistributionPowerModelSpecification" id="_EzkPUDqsEeSeEKsoUNmaIw" name="Linear Passthrough Model">
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_b_IXADqsEeSeEKsoUNmaIw" name="Constant Loss"/>
  </powerModelSpecifications>
  <powerModelSpecifications xsi:type="de.fzi.power:DeclarativePowerModelSpecification" id="_R_P5QmOQEeWW76L-WpK6kQ" name="Declarative Linear Power Model" functionalExpression="IdleConsumption + Utilization * (MaxConsumption - IdleConsumption)">
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_hpdvYGOQEeWW76L-WpK6kQ" name="IdleConsumption"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_jHYe4GOQEeWW76L-WpK6kQ" name="MaxConsumption"/>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_ku090WOQEeWW76L-WpK6kQ" name="Utilization">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricspec#_QIb6cikUEeSuf8LV7cHLgA"/>
    </consumptionFactors>
  </powerModelSpecifications>
  <powerModelSpecifications xsi:type="de.fzi.power:DeclarativePowerModelSpecification" id="_iIhDwGd-EeWSzN49MVDdQw" name="Declarative Linear Passthrough Model" functionalExpression="SUM(Consumers)+ConstantLoss">
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_xYoX0Wd-EeWSzN49MVDdQw" name="Consumers">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricspec#_NbIowlt_EeS0LdH-diVVEQ"/>
    </consumptionFactors>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_5v610GghEeWM8bUtzui0_Q" name="ConstantLoss"/>
  </powerModelSpecifications>
</de.fzi.power:PowerModelRepository>
