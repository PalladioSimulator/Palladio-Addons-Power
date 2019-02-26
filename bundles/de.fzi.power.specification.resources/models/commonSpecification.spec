<?xml version="1.0" encoding="UTF-8"?>
<de.fzi.power:PowerModelRepository xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:de.fzi.power="http://www.fzi.de/Power/Specification/1.0" id="_yakpMDnDEeSXp6PobgrWpg">
  <powerModelSpecifications xsi:type="de.fzi.power:BlackBoxResourcePowerModelSpecification" id="_daqEMDgXEeSFuYf_V61WsQ" name="Linear Power Model">
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_vkR8ADgXEeS9Ksbwfez2QA" name="Idle Consumption"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_yosvQDgXEeS9Ksbwfez2QA" name="Maximum Consumption"/>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_2l6y0jnEEeSXp6PobgrWpg" name="Utilization">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricspec#_QIb6cikUEeSuf8LV7cHLgA"/>
    </consumptionFactors>
  </powerModelSpecifications>
  <powerModelSpecifications xsi:type="de.fzi.power:BlackBoxResourcePowerModelSpecification" id="_daqEMDgXEeSFuYp_X61Wsr" name="Non-Linear Regression Power Model">
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_vkR8ADgXEeS9Ksbwfez3NA" name="Idle Consumption"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_yosvQDgXEeS9Ksbwfqy4NA" name="Maximum Consumption"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_yosvQDgZGeS9Ksbwfqy4NA" name="Exponent"/>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_2l6y0jnEEeSWp6PobgrW4NA" name="Utilization">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricspec#_QIb6cikUEeSuf8LV7cHLgA"/>
    </consumptionFactors>
  </powerModelSpecifications>
  <powerModelSpecifications xsi:type="de.fzi.power:BlackBoxResourcePowerModelSpecification" id="_daqEMDgXEeSFuYp_X61Wxp" name="0.1*n Interpolation Model">
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
  <powerModelSpecifications xsi:type="de.fzi.power:BlackBoxDistributionPowerModelSpecification" id="_EzkPUDqsEeSeEKsoUNmaIw" name="Linear Passthrough Model">
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_b_IXADqsEeSeEKsoUNmaIw" name="Constant Loss"/>
  </powerModelSpecifications>
  <powerModelSpecifications xsi:type="de.fzi.power:DeclarativeResourcePowerModelSpecification" id="_R_P5QmOQEeWW76L-WpK6kQ" name="Declarative Linear Power Model" functionalExpression="IdleConsumption + Utilization * (MaxConsumption - IdleConsumption)">
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_hpdvYGOQEeWW76L-WpK6kQ" name="IdleConsumption"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_jHYe4GOQEeWW76L-WpK6kQ" name="MaxConsumption"/>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_ku090WOQEeWW76L-WpK6kQ" name="Utilization">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricspec#_QIb6cikUEeSuf8LV7cHLgA"/>
    </consumptionFactors>
  </powerModelSpecifications>
  <powerModelSpecifications xsi:type="de.fzi.power:DeclarativeDistributionPowerModelSpecification" id="_iIhDwGd-EeWSzN49MVDdQw" name="Declarative Linear Passthrough Model" functionalExpression="SUM(Consumers)+ConstantLoss">
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_xYoX0Wd-EeWSzN49MVDdQw" name="Consumers">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricspec#_NbIowlt_EeS0LdH-diVVEQ"/>
    </consumptionFactors>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_5v610GghEeWM8bUtzui0_Q" name="ConstantLoss"/>
  </powerModelSpecifications>
  <powerModelSpecifications xsi:type="de.fzi.power:DeclarativeResourcePowerModelSpecification" id="_vSu1IBLOEeawp_3Ecfe76A" name="Polynomial BFEPM Paper" functionalExpression="a+b*Utilization+c*Utilization*Utilization+d*Utilization*Utilization*Utilization">
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_zb0xcBLOEeawp_3Ecfe76A" name="a"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_0wdCEBLOEeawp_3Ecfe76A" name="b"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_1yJvoBLOEeawp_3Ecfe76A" name="c"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_2PS-oBLOEeawp_3Ecfe76A" name="d"/>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_2--vIRLOEeawp_3Ecfe76A" name="Utilization">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricspec#_QIb6cikUEeSuf8LV7cHLgA"/>
    </consumptionFactors>
  </powerModelSpecifications>
</de.fzi.power:PowerModelRepository>
