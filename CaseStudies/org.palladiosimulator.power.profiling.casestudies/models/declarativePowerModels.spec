<?xml version="1.0" encoding="UTF-8"?>
<de.fzi.power:PowerModelRepository xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:de.fzi.power="http://www.fzi.de/Power/Specification/1.0" id="_bOxcMH1gEeWUt_x9QCHofA">
  <powerModelSpecifications xsi:type="de.fzi.power:DeclarativePowerModelSpecification" id="_culCEn1gEeWUt_x9QCHofA" name="Declarative Linear Power Model (Test)" functionalExpression="IdleConsumption + Utilization * (MaxConsumption - IdleConsumption)">
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_gcoBIH1gEeWUt_x9QCHofA" name="IdleConsumption"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_hkCVIH1gEeWUt_x9QCHofA" name="MaxConsumption"/>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_ksukYX1gEeWUt_x9QCHofA" name="Utilization">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_QIb6cikUEeSuf8LV7cHLgA"/>
    </consumptionFactors>
  </powerModelSpecifications>
  <powerModelSpecifications xsi:type="de.fzi.power:DeclarativePowerModelSpecification" id="_K7tkwk9TEeaevdhGrMtmSA" name="Linear Power Model CPU HDD" functionalExpression="n*Utilization+m*read+o*write+q">
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_gcoBIH1gEeWUt_x9QCHofA2" name="n"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_hkCVIH1gEeWUt_x9QCHofA2" name="m"/>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_ksukYX1gEeWUt_x9QCHofA2" name="Utilization">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_QIb6cikUEeSuf8LV7cHLgA"/>
    </consumptionFactors>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_byq60U9TEeaevdhGrMtmSA" name="read">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_dwmeElVcEea-nOJ8YX6eWg"/>
    </consumptionFactors>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_cMJx0U9TEeaevdhGrMtmSA" name="write">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_1Q6twlVcEea-nOJ8YX6eWg"/>
    </consumptionFactors>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_oUcZUE9TEeaevdhGrMtmSA" name="o"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_AgXKwE9UEeaevdhGrMtmSA" name="q"/>
  </powerModelSpecifications>
  <powerModelSpecifications xsi:type="de.fzi.power:DeclarativePowerModelSpecification" id="_on3u0n1hEeWs5NTiSBh3Qw" name="Declarative Linear Passthrough Model (Test)" functionalExpression="SUM(Consumers)+ConstantLoss">
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_tt_7JX1hEeWs5NTiSBh3Qw" name="ConstantLoss"/>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_u7zyEX1hEeWs5NTiSBh3Qw" name="Consumers">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_NbIowlt_EeS0LdH-diVVEQ"/>
    </consumptionFactors>
  </powerModelSpecifications>
  <powerModelSpecifications xsi:type="de.fzi.power:DeclarativePowerModelSpecification" id="_p0__YoI6EeW9D58bfYJKTQ" name="Declarative StandBy Power Model (Test)" functionalExpression="StandbyConsumption">
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_19KEAII6EeW9D58bfYJKTQ" name="StandbyConsumption"/>
  </powerModelSpecifications>
  <powerModelSpecifications xsi:type="de.fzi.power:DeclarativePowerModelSpecification" id="_JrUa8VgGEeaHDMHWpSqWyA" name="bfepm pow 3 CPU HDD" functionalExpression="c0+cp1*up+cp2*pow(up,2)+cp3*pow(up,3)+cr1*ur+cr2*pow(ur,2)+cr3*pow(ur,3)+cw1*uw+cw2*pow(uw,2)+cw3*pow(uw,3)">
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_OLzjkFgGEeaHDMHWpSqWyA" name="c0"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_O05j4FgGEeaHDMHWpSqWyA" name="cp1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_PW1zUFgGEeaHDMHWpSqWyA" name="cp2"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_QJRV0FgGEeaHDMHWpSqWyA" name="cp3"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_RU6pkFgGEeaHDMHWpSqWyA" name="cr1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_Tb_q0FgGEeaHDMHWpSqWyA" name="cr2"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_UCEzYFgGEeaHDMHWpSqWyA" name="cr3"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_UjBkUFgGEeaHDMHWpSqWyA" name="cw1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_VCfHgFgGEeaHDMHWpSqWyA" name="cw2"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_VYho8FgGEeaHDMHWpSqWyA" name="cw3"/>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_duQk0VgGEeaHDMHWpSqWyA" name="up">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_QIb6cikUEeSuf8LV7cHLgA"/>
    </consumptionFactors>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_gvgIQVgGEeaHDMHWpSqWyA" name="ur">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_dwmeElVcEea-nOJ8YX6eWg"/>
    </consumptionFactors>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_hWi6IVgGEeaHDMHWpSqWyA" name="uw">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_1Q6twlVcEea-nOJ8YX6eWg"/>
    </consumptionFactors>
  </powerModelSpecifications>
  <powerModelSpecifications xsi:type="de.fzi.power:DeclarativePowerModelSpecification" id="_JrUa8VgGEeaHDMHWpSqWyA2" name="bfepm pow 2 CPU HDD" functionalExpression="c0+cp1*up+cp2*pow(up,2)+cr1*ur+cr2*pow(ur,2)+cw1*uw+cw2*pow(uw,2)">
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_OLzjkFgGEeaHDMHWpSqWyA2" name="c0"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_O05j4FgGEeaHDMHWpSqWyA2" name="cp1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_PW1zUFgGEeaHDMHWpSqWyA2" name="cp2"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_RU6pkFgGEeaHDMHWpSqWyA2" name="cw1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_Tb_q0FgGEeaHDMHWpSqWyA2" name="cw2"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_UjBkUFgGEeaHDMHWpSqWyA2" name="cr1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_VCfHgFgGEeaHDMHWpSqWyA2" name="cr2"/>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_duQk0VgGEeaHDMHWpSqWyA2" name="up">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_QIb6cikUEeSuf8LV7cHLgA"/>
    </consumptionFactors>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_gvgIQVgGEeaHDMHWpSqWyA2" name="ur">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_dwmeElVcEea-nOJ8YX6eWg"/>
    </consumptionFactors>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_hWi6IVgGEeaHDMHWpSqWyA2" name="uw">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_1Q6twlVcEea-nOJ8YX6eWg"/>
    </consumptionFactors>
  </powerModelSpecifications>
  <powerModelSpecifications xsi:type="de.fzi.power:DeclarativePowerModelSpecification" id="_JrUaa8VgGEeaHDMHWpSqWyAC3" name="bfepm pow 3 CPU" functionalExpression="c0+cp1*up+cp2*pow(up,2)+cp3*pow(up,3)">
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_OLazjkFgGEeaHDMHWpSqWyAC3" name="c0"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_O0a5j4FgGEeaHDMHWpSqWyAC3" name="cp1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_PW1azUFgGEeaHDMHWpSqWyAC3" name="cp2"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_QJaRV0FgGEeaHDMHWpSqWyAC3" name="cp3"/>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_duQka0VgGEeaHDMHWpSqWyAC3" name="up">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_QIb6cikUEeSuf8LV7cHLgA"/>
    </consumptionFactors>
  </powerModelSpecifications>
  <powerModelSpecifications xsi:type="de.fzi.power:DeclarativePowerModelSpecification" id="_JrUa8VgaGEeaHDMHWpSqWyAC2" name="bfepm pow 2 CPU" functionalExpression="c0+cp1*up+cp2*pow(up,2)">
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_OaLzjkFgGEeaHDMHWpSqWyAC2" name="c0"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_Oa05j4FgGEeaHDMHWpSqWyAC2" name="cp1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_PaW1zUFgGEeaHDMHWpSqWyAC2" name="cp2"/>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_dauQk0VgGEeaHDMHWpSqWyAC2" name="up">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_QIb6cikUEeSuf8LV7cHLgA"/>
    </consumptionFactors>
  </powerModelSpecifications>
  <powerModelSpecifications xsi:type="de.fzi.power:DeclarativePowerModelSpecification" id="_3tX0AlfLEeaJt52aq6__tg" name="Exponential CPU" functionalExpression="ec0+ec1*pow(eu, ealpha)">
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_OzNuMFfMEeaJt52aq6__tg" name="ec0"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_PeRdYFfMEeaJt52aq6__tg" name="ec1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_QASlUFfMEeaJt52aq6__tg" name="ealpha"/>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_fWGaQVfjEea7OsMR5tXcqA" name="eu">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_QIb6cikUEeSuf8LV7cHLgA"/>
    </consumptionFactors>
  </powerModelSpecifications>
  <powerModelSpecifications xsi:type="de.fzi.power:DeclarativePowerModelSpecification" id="_JraUa8VgGEeaHDMHWpSqWyA" name="bfepm pow 3 exp CPU HDD" functionalExpression="c0+cp1*(up+exp(up))+cp2*(pow(up,2)+exp(up))+cp3*(pow(up,3)+exp(up))+cr1*(ur+exp(ur))+cr2*(pow(ur,2)+exp(ur))+cr3*(pow(ur,3)+exp(ur))+cw1*(uw+exp(uw))+cw2*(pow(uw,2)+exp(uw))+cw3*(pow(uw,3)+exp(uw))">
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_OLzjkFgGEeaHDMHWpSqWyA3" name="c0"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_O05j4FgGEeaHDMHWpSqWyA3" name="cp1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_PW1zUFgGEeaHDMHWpSqWyA3" name="cp2"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_QJRV0FgGEeaHDMHWpSqWyA3" name="cp3"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_RU6pkFgGEeaHDMHWpSqWyA3" name="cr1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_Tb_q0FgGEeaHDMHWpSqWyA3" name="cr2"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_UCEzYFgGEeaHDMHWpSqWyA3" name="cr3"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_UjBkUFgGEeaHDMHWpSqWyA3" name="cw1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_VCfHgFgGEeaHDMHWpSqWyA3" name="cw2"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_VYho8FgGEeaHDMHWpSqWyA3" name="cw3"/>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_duQk0VgGEeaHDMHWpSqWyA3" name="up">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_QIb6cikUEeSuf8LV7cHLgA"/>
    </consumptionFactors>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_gvgIQVgGEeaHDMHWpSqWyA3" name="ur">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_dwmeElVcEea-nOJ8YX6eWg"/>
    </consumptionFactors>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_hWi6IVgGEeaHDMHWpSqWyA3" name="uw">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_1Q6twlVcEea-nOJ8YX6eWg"/>
    </consumptionFactors>
  </powerModelSpecifications>
  <powerModelSpecifications xsi:type="de.fzi.power:DeclarativePowerModelSpecification" id="de171b2699ec400fa24ba3975767d89a" name="bfepm pow 2 exp CPU HDD" functionalExpression="c0+cp1*(up+exp(up))+cp2*(pow(up,2)+exp(up))+cr1*(ur+exp(ur))+cr2*(pow(ur,2)+exp(ur))+cw1*(uw+exp(uw))+cw2*(pow(uw,2)+exp(uw))">
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="de171b2699ec400fa24ba3975767d89a1" name="c0"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="de171b2699ec400fa24ba3975767d89a2" name="cp1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="de171b2699ec400fa24ba3975767d89a3" name="cp2"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="de171b2699ec400fa24ba3975767d89a4" name="cr1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="de171b2699ec400fa24ba3975767d89a5" name="cr2"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="de171b2699ec400fa24ba3975767d89a6" name="cw1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="de171b2699ec400fa24ba3975767d89a7" name="cw2"/>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="de171b2699ec400fa24ba3975767d89a8" name="up">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_QIb6cikUEeSuf8LV7cHLgA"/>
    </consumptionFactors>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="de171b2699ec400fa24ba3975767d89a9" name="ur">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_dwmeElVcEea-nOJ8YX6eWg"/>
    </consumptionFactors>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="de171b2699ec400fa24ba3975767d89a0" name="uw">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_1Q6twlVcEea-nOJ8YX6eWg"/>
    </consumptionFactors>
  </powerModelSpecifications>
  <powerModelSpecifications xsi:type="de.fzi.power:DeclarativePowerModelSpecification" id="_JrUa8VgGEeaHDMHWpSqWyAC3" name="bfepm pow 3 exp CPU" functionalExpression="c0+cp1*(up+exp(up))+cp2*(pow(up,2)+exp(up))+cp3*(pow(up,3)+exp(up))">
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_OLzjkFgGEeaHDMHWpSqWyAC3" name="c0"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_O05j4FgGEeaHDMHWpSqWyAC3" name="cp1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_PW1zUFgGEeaHDMHWpSqWyAC3" name="cp2"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_QJRV0FgGEeaHDMHWpSqWyAC3" name="cp3"/>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_duQk0VgGEeaHDMHWpSqWyAC3" name="up">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_QIb6cikUEeSuf8LV7cHLgA"/>
    </consumptionFactors>
  </powerModelSpecifications>
  <powerModelSpecifications xsi:type="de.fzi.power:DeclarativePowerModelSpecification" id="_JrUa8VgGEeaHDMHWpSqWyAC2" name="bfepm pow 2 exp CPU" functionalExpression="c0+cp1*(up+exp(up))+cp2*(pow(up,2)+exp(up))">
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_OLzjkFgGEeaHDMHWpSqWyAC2" name="c0"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_O05j4FgGEeaHDMHWpSqWyAC2" name="cp1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_PW1zUFgGEeaHDMHWpSqWyAC2" name="cp2"/>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_duQk0VgGEeaHDMHWpSqWyAC2" name="up">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_QIb6cikUEeSuf8LV7cHLgA"/>
    </consumptionFactors>
  </powerModelSpecifications>
  <powerModelSpecifications xsi:type="de.fzi.power:DeclarativePowerModelSpecification" id="_JrUa8VgGEeaHDMHWpSqWyAC1" name="bfepm pow exp CPU" functionalExpression="c0+cp1*(up+exp(up))">
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_OLzjkFgGEeaHDMHWpSqWyAC1" name="c0"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_O05j4FgGEeaHDMHWpSqWyAC1" name="cp1"/>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_duQk0VgGEeaHDMHWpSqWyAC1" name="up">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_QIb6cikUEeSuf8LV7cHLgA"/>
    </consumptionFactors>
  </powerModelSpecifications>
  <powerModelSpecifications xsi:type="de.fzi.power:DeclarativePowerModelSpecification" id="_3tX0AlfLEeaJt52aq6__tgL" name="Exponential Linear CPU" functionalExpression="ec0+ec1*eu+ec2*pow(eu, ealpha)">
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_OzNuMFfMEeaJt52aq6__tgL" name="ec0"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_PeRdYFfMEeaJt52aq6__tgL" name="ec1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_uEXhEFiJEeaHDMHWpSqWyA" name="ec2"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_QASlUFfMEeaJt52aq6__tgL" name="ealpha"/>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_fWGaQVfjEea7OsMR5tXcqAL" name="eu">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_QIb6cikUEeSuf8LV7cHLgA"/>
    </consumptionFactors>
  </powerModelSpecifications>
  <powerModelSpecifications xsi:type="de.fzi.power:DeclarativePowerModelSpecification" id="_iknq0liKEeaHDMHWpSqWyA" name="CPU pow with linear" functionalExpression="c0+cp1*eu+cp2*pow(eu,ealpha)">
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_oE41cFiKEeaHDMHWpSqWyA" name="c0"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_pjzqgFiKEeaHDMHWpSqWyA" name="cp1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_qMFygFiKEeaHDMHWpSqWyA" name="cp2"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_qqYRAFiKEeaHDMHWpSqWyA" name="ealpha"/>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_fWGaQVfjEea7OsMR5tXcALE" name="eu">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_QIb6cikUEeSuf8LV7cHLgA"/>
    </consumptionFactors>
  </powerModelSpecifications>
  <powerModelSpecifications xsi:type="de.fzi.power:DeclarativePowerModelSpecification" id="_YHGUgli1EeanpcBednRjuQ" name="bfepm exponential CPU" functionalExpression="cp1*exp(-pow(((eu-cp2)/ealpha1),2))">
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_uZk4EFi1EeanpcBednRjuQ" name="cp1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_vDGWMFi1EeanpcBednRjuQ" name="cp2"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_wBBXAFi1EeanpcBednRjuQ" name="ealpha1"/>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_fWGaQVfjEea7OsMR5tXcBE" name="eu">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_QIb6cikUEeSuf8LV7cHLgA"/>
    </consumptionFactors>
  </powerModelSpecifications>
  <powerModelSpecifications xsi:type="de.fzi.power:DeclarativePowerModelSpecification" id="_culCEn1gEeWUt_x9QCHofAF" name="Linear Power Model Fixed Min" functionalExpression="280 + Utilization * (MaxConsumption - 280)">
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_hkCVIH1gEeWUt_x9QCHofAF" name="MaxConsumption"/>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_ksukYX1gEeWUt_x9QCHofAF" name="Utilization">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_QIb6cikUEeSuf8LV7cHLgA"/>
    </consumptionFactors>
  </powerModelSpecifications>
  <powerModelSpecifications xsi:type="de.fzi.power:DeclarativePowerModelSpecification" id="_3tX0AlfLEeaJt52aq6__tgF" name="Exponential CPU Fixed Min" functionalExpression="280+ec1*pow(eu, ealpha)">
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_PeRdYFfMEeaJt52aq6__tgF" name="ec1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_QASlUFfMEeaJt52aq6__tgF" name="ealpha"/>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_fWGaQVfjEea7OsMR5tXcqAF" name="eu">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_QIb6cikUEeSuf8LV7cHLgA"/>
    </consumptionFactors>
  </powerModelSpecifications>
  <powerModelSpecifications xsi:type="de.fzi.power:DeclarativePowerModelSpecification" id="_K7tkwk9TEeaevdhGrMtmSAF" name="Linear Power Model CPU HDD Fixed Min" functionalExpression="n*Utilization+m*read+o*write+280">
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_gcoBIH1gEeWUt_x9QCHofA2F" name="n"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_hkCVIH1gEeWUt_x9QCHofA2F" name="m"/>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_ksukYX1gEeWUt_x9QCHofA2F" name="Utilization">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_QIb6cikUEeSuf8LV7cHLgA"/>
    </consumptionFactors>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_byq60U9TEeaevdhGrMtmSAF" name="read">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_dwmeElVcEea-nOJ8YX6eWg"/>
    </consumptionFactors>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_cMJx0U9TEeaevdhGrMtmSAF" name="write">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_1Q6twlVcEea-nOJ8YX6eWg"/>
    </consumptionFactors>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_oUcZUE9TEeaevdhGrMtmSAF" name="o"/>
  </powerModelSpecifications>
  <powerModelSpecifications xsi:type="de.fzi.power:DeclarativePowerModelSpecification" id="_JrUa8VgGEeaHDMHWpSqWyAF" name="bfepm pow 3 CPU HDD Fixed Min" functionalExpression="280+cp1*up+cp2*pow(up,2)+cp3*pow(up,3)+cw1*ur+cw2*pow(ur,2)+cw3*pow(ur,3)+cr1*uw+cr2*pow(uw,2)+cr3*pow(uw,3)">
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_O05j4FgGEeaHDMHWpSqWyAF" name="cp1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_PW1zUFgGEeaHDMHWpSqWyAF" name="cp2"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_QJRV0FgGEeaHDMHWpSqWyAF" name="cp3"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_RU6pkFgGEeaHDMHWpSqWyAF" name="cr1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_Tb_q0FgGEeaHDMHWpSqWyAF" name="cr2"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_UCEzYFgGEeaHDMHWpSqWyAF" name="cr3"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_UjBkUFgGEeaHDMHWpSqWyAF" name="cw1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_VCfHgFgGEeaHDMHWpSqWyAF" name="cw2"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_VYho8FgGEeaHDMHWpSqWyAF" name="cw3"/>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_duQk0VgGEeaHDMHWpSqWyAF" name="up">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_QIb6cikUEeSuf8LV7cHLgA"/>
    </consumptionFactors>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_gvgIQVgGEeaHDMHWpSqWyAF" name="ur">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_dwmeElVcEea-nOJ8YX6eWg"/>
    </consumptionFactors>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_hWi6IVgGEeaHDMHWpSqWyAF" name="uw">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_1Q6twlVcEea-nOJ8YX6eWg"/>
    </consumptionFactors>
  </powerModelSpecifications>
  <powerModelSpecifications xsi:type="de.fzi.power:DeclarativePowerModelSpecification" id="74bba0d7d6b34c518bf3a45d4ec82823" name="bfepm pow 2 CPU HDD Fixed Min" functionalExpression="280+cp1*up+cp2*pow(up,2)+cw1*ur+cw2*pow(ur,2)+cr1*uw+cr2*pow(uw,2)">
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="3a19adc3db0b4b1dada1836d40e1056e" name="cp1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="3a19adc3db0b4b1dada1836d40e1056e2" name="cp2"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="3a19adc3db0b4b1dada1836d40e1056e3" name="cr1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="3a19adc3db0b4b1dada1836d40e1056e4" name="cr2"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="3a19adc3db0b4b1dada1836d40e1056e5" name="cw1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="3a19adc3db0b4b1dada1836d40e1056e6" name="cw2"/>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="3a19adc3db0b4b1dada1836d40e1056e7" name="up">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_QIb6cikUEeSuf8LV7cHLgA"/>
    </consumptionFactors>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="3a19adc3db0b4b1dada1836d40e1056e8" name="ur">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_dwmeElVcEea-nOJ8YX6eWg"/>
    </consumptionFactors>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="3a19adc3db0b4b1dada1836d40e1056e9" name="uw">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_1Q6twlVcEea-nOJ8YX6eWg"/>
    </consumptionFactors>
  </powerModelSpecifications>
  <powerModelSpecifications xsi:type="de.fzi.power:DeclarativePowerModelSpecification" id="11108a1ed84c42c3b9e384fa350deb63" name="bfepm pow 3 exp CPU HDD Fixed Min" functionalExpression="280+cp1*(up+exp(up))+cp2*(pow(up,2)+exp(up))+cp3*(pow(up,3)+exp(up))+cw1*(ur+exp(ur))+cw2*(pow(ur,2)+exp(ur))+cw3*(pow(ur,3)+exp(ur))+cr1*(uw+exp(ur))+cr2*(pow(uw,2)+exp(ur))+cr3*(pow(uw,3)+exp(ur))">
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="11108a1ed84c42c3b9e384fa350deb631" name="cp1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="11108a1ed84c42c3b9e384fa350deb632" name="cp2"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="11108a1ed84c42c3b9e384fa350deb633" name="cp3"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="11108a1ed84c42c3b9e384fa350deb634" name="cr1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="11108a1ed84c42c3b9e384fa350deb635" name="cr2"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="11108a1ed84c42c3b9e384fa350deb636" name="cr3"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="11108a1ed84c42c3b9e384fa350deb637" name="cw1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="11108a1ed84c42c3b9e384fa350deb638" name="cw2"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="11108a1ed84c42c3b9e384fa350deb639" name="cw3"/>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="11108a1ed84c42c3b9e384fa350deb630" name="up">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_QIb6cikUEeSuf8LV7cHLgA"/>
    </consumptionFactors>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="6e62de57ef964a9382c86b7afb2dcc8c" name="ur">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_dwmeElVcEea-nOJ8YX6eWg"/>
    </consumptionFactors>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="6e62de57ef964a9382c86b7afb2dcc8c1" name="uw">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_1Q6twlVcEea-nOJ8YX6eWg"/>
    </consumptionFactors>
  </powerModelSpecifications>
  <powerModelSpecifications xsi:type="de.fzi.power:DeclarativePowerModelSpecification" id="03d67c321bcf4f7b8f05bee6148fc198" name="bfepm pow exp CPU HDD" functionalExpression="c0+cp1*(up+exp(up))+cr1*(ur+exp(ur))+cw1*(uw+exp(uw))">
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="03d67c321bcf4f7b8f05bee6148fc1981" name="c0"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="03d67c321bcf4f7b8f05bee6148fc1982" name="cp1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="03d67c321bcf4f7b8f05bee6148fc1984" name="cr1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="03d67c321bcf4f7b8f05bee6148fc1986" name="cw1"/>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="03d67c321bcf4f7b8f05bee6148fc1988" name="up">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_QIb6cikUEeSuf8LV7cHLgA"/>
    </consumptionFactors>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="03d67c321bcf4f7b8f05bee6148fc1989" name="ur">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_dwmeElVcEea-nOJ8YX6eWg"/>
    </consumptionFactors>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="03d67c321bcf4f7b8f05bee6148fc1980" name="uw">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_1Q6twlVcEea-nOJ8YX6eWg"/>
    </consumptionFactors>
  </powerModelSpecifications>
  <powerModelSpecifications xsi:type="de.fzi.power:DeclarativePowerModelSpecification" id="0eab9c61bdcc40bdb1c56493c20a5ba7" name="bfepm pow 3 exp CPU Fixed Min Linear HDD" functionalExpression="280+cp1*(up+exp(up))+cp2*(pow(up,2)+exp(up))+cp3*(pow(up,3)+exp(up))+cr1*ur+cw1*uw">
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="0eab9c61bdcc40bdb1c56493c20a5ba71" name="cp1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="0eab9c61bdcc40bdb1c56493c20a5ba72" name="cp2"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="0eab9c61bdcc40bdb1c56493c20a5ba73" name="cp3"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="0eab9c61bdcc40bdb1c56493c20a5ba75" name="cr1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="0eab9c61bdcc40bdb1c56493c20a5ba76" name="cw1"/>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="0eab9c61bdcc40bdb1c56493c20a5ba77" name="up">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_QIb6cikUEeSuf8LV7cHLgA"/>
    </consumptionFactors>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="0eab9c61bdcc40bdb1c56493c20a5ba78" name="ur">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_dwmeElVcEea-nOJ8YX6eWg"/>
    </consumptionFactors>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="0eab9c61bdcc40bdb1c56493c20a5ba79" name="uw">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_1Q6twlVcEea-nOJ8YX6eWg"/>
    </consumptionFactors>
  </powerModelSpecifications>
  <powerModelSpecifications xsi:type="de.fzi.power:DeclarativePowerModelSpecification" id="_zOH18m3OEeaV-I16CijOww" name="bfepm pow 3 CPU HDD Write" functionalExpression="c0+cp1*up+cp2*pow(up,2)+cp3*pow(up,3)+cw1*uw+cw2*pow(uw,2)+cw3*pow(uw,3)">
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_OLzjkFgGEeaHDMHWpSqWyA3w" name="c0"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_O05j4FgGEeaHDMHWpSqWyA3w" name="cp1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_PW1zUFgGEeaHDMHWpSqWyA3w" name="cp2"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_QJRV0FgGEeaHDMHWpSqWyA3w" name="cp3"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_UjBkUFgGEeaHDMHWpSqWyA3w" name="cw1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_VCfHgFgGEeaHDMHWpSqWyA3w" name="cw2"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_VYho8FgGEeaHDMHWpSqWyA3w" name="cw3"/>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_duQk0VgGEeaHDMHWpSqWyA3w" name="up">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_QIb6cikUEeSuf8LV7cHLgA"/>
    </consumptionFactors>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_hWi6IVgGEeaHDMHWpSqWyA3w" name="uw">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_1Q6twlVcEea-nOJ8YX6eWg"/>
    </consumptionFactors>
  </powerModelSpecifications>
  <powerModelSpecifications xsi:type="de.fzi.power:DeclarativePowerModelSpecification" id="_C93T8m6NEeaV-I16CijOww" name="bfepm pow 3 CPU HDD Read" functionalExpression="c0+cp1*up+cp2*pow(up,2)+cp3*pow(up,3)+cr1*ur+cr2*pow(ur,2)+cr3*pow(ur,3)">
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_OLzjkFgGEeaHDMHWpSqWyA3r" name="c0"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_O05j4FgGEeaHDMHWpSqWyA3r" name="cp1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_PW1zUFgGEeaHDMHWpSqWyA3r" name="cp2"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_QJRV0FgGEeaHDMHWpSqWyA3r" name="cp3"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_RU6pkFgGEeaHDMHWpSqWyA3r" name="cr1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_Tb_q0FgGEeaHDMHWpSqWyA3r" name="cr2"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_UCEzYFgGEeaHDMHWpSqWyA3r" name="cr3"/>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_duQk0VgGEeaHDMHWpSqWyAr" name="up">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_QIb6cikUEeSuf8LV7cHLgA"/>
    </consumptionFactors>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_gvgIQVgGEeaHDMHWpSqWyAr" name="ur">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_dwmeElVcEea-nOJ8YX6eWg"/>
    </consumptionFactors>
  </powerModelSpecifications>
  <powerModelSpecifications xsi:type="de.fzi.power:DeclarativePowerModelSpecification" id="de171b2699ec400fa24ba3975767d89aw" name="bfepm pow 2 exp CPU HDD Write" functionalExpression="c0+cp1*(up+exp(up))+cp2*(pow(up,2)+exp(up))+cw1*(uw+exp(uw))+cw2*(pow(uw,2)+exp(uw))">
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="de171b2699ec400fa24ba3975767d89a1w" name="c0"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="de171b2699ec400fa24ba3975767d89a2w" name="cp1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="de171b2699ec400fa24ba3975767d89a3w" name="cp2"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="de171b2699ec400fa24ba3975767d89a6w" name="cw1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="de171b2699ec400fa24ba3975767d89a7w" name="cw2"/>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="de171b2699ec400fa24ba3975767d89a8ww" name="up">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_QIb6cikUEeSuf8LV7cHLgA"/>
    </consumptionFactors>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="de171b2699ec400fa24ba3975767d89a0w" name="uw">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_1Q6twlVcEea-nOJ8YX6eWg"/>
    </consumptionFactors>
  </powerModelSpecifications>
  <powerModelSpecifications xsi:type="de.fzi.power:DeclarativePowerModelSpecification" id="_JrUa8VgGEeaHDMHWpSqWyA2w" name="bfepm pow 2 CPU HDD Write" functionalExpression="c0+cp1*up+cp2*pow(up,2)+cw1*uw+cw2*pow(uw,2)">
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_OLzjkFgGEeaHDMHWpSqWyA2w" name="c0"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_O05j4FgGEeaHDMHWpSqWyA2w" name="cp1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_PW1zUFgGEeaHDMHWpSqWyA2w" name="cp2"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_RU6pkFgGEeaHDMHWpSqWyA2w" name="cw1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_Tb_q0FgGEeaHDMHWpSqWyA2w" name="cw2"/>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_duQk0VgGEeaHDMHWpSqWyA2w" name="up">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_QIb6cikUEeSuf8LV7cHLgA"/>
    </consumptionFactors>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_hWi6IVgGEeaHDMHWpSqWyA2w" name="uw">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_1Q6twlVcEea-nOJ8YX6eWg"/>
    </consumptionFactors>
  </powerModelSpecifications>
  <powerModelSpecifications xsi:type="de.fzi.power:DeclarativePowerModelSpecification" id="_JrUa8VgGEeaHDMHWpSqWyA2r" name="bfepm pow 2 CPU HDD Read" functionalExpression="c0+cp1*up+cp2*pow(up,2)+cr1*ur+cr2*pow(ur,2)">
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_OLzjkFgGEeaHDMHWpSqWyA2r" name="c0"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_O05j4FgGEeaHDMHWpSqWyA2r" name="cp1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_PW1zUFgGEeaHDMHWpSqWyA2r" name="cp2"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_UjBkUFgGEeaHDMHWpSqWyA2r" name="cr1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_VCfHgFgGEeaHDMHWpSqWyA2r" name="cr2"/>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_duQk0VgGEeaHDMHWpSqWyA2r" name="up">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_QIb6cikUEeSuf8LV7cHLgA"/>
    </consumptionFactors>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_gvgIQVgGEeaHDMHWpSqWyA2r" name="ur">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_dwmeElVcEea-nOJ8YX6eWg"/>
    </consumptionFactors>
  </powerModelSpecifications>
  <powerModelSpecifications xsi:type="de.fzi.power:DeclarativePowerModelSpecification" id="de171b2699ec400fa24ba3975767d89ar" name="bfepm pow 2 exp CPU HDD Read" functionalExpression="c0+cp1*(up+exp(up))+cp2*(pow(up,2)+exp(up))+cr1*(ur+exp(ur))+cr2*(pow(ur,2)+exp(ur))">
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="de171b2699ec400fa24ba3975767d89a1r" name="c0"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="de171b2699ec400fa24ba3975767d89a2r" name="cp1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="de171b2699ec400fa24ba3975767d89a3r" name="cp2"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="de171b2699ec400fa24ba3975767d89a4r" name="cr1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="de171b2699ec400fa24ba3975767d89a5r" name="cr2"/>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="de171b2699ec400fa24ba3975767d89a8r" name="up">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_QIb6cikUEeSuf8LV7cHLgA"/>
    </consumptionFactors>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="de171b2699ec400fa24ba3975767d89a9r" name="ur">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_dwmeElVcEea-nOJ8YX6eWg"/>
    </consumptionFactors>
  </powerModelSpecifications>
  <powerModelSpecifications xsi:type="de.fzi.power:DeclarativePowerModelSpecification" id="_JraUa8VgGEeaHDMHWpSqWyAw" name="bfepm pow 3 exp CPU HDD Write" functionalExpression="c0+cp1*(up+exp(up))+cp2*(pow(up,2)+exp(up))+cp3*(pow(up,3)+exp(up))+cw1*(uw+exp(uw))+cw2*(pow(uw,2)+exp(uw))+cw3*(pow(uw,3)+exp(uw))">
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_OLzjkFgGEeaHDMHWpSqWyA3w" name="c0"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_O05j4FgGEeaHDMHWpSqWyA3w" name="cp1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_PW1zUFgGEeaHDMHWpSqWyA3w" name="cp2"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_QJRV0FgGEeaHDMHWpSqWyA3w" name="cp3"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_UjBkUFgGEeaHDMHWpSqWyA3w" name="cw1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_VCfHgFgGEeaHDMHWpSqWyA3w" name="cw2"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_VYho8FgGEeaHDMHWpSqWyA3w" name="cw3"/>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_duQk0VgGEeaHDMHWpSqWyA3w" name="up">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_QIb6cikUEeSuf8LV7cHLgA"/>
    </consumptionFactors>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_hWi6IVgGEeaHDMHWpSqWyA3w" name="uw">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_1Q6twlVcEea-nOJ8YX6eWg"/>
    </consumptionFactors>
  </powerModelSpecifications>
  <powerModelSpecifications xsi:type="de.fzi.power:DeclarativePowerModelSpecification" id="_JrUa8VgGEeaHDMHWpSqWyAr" name="bfepm pow 3 exp CPU HDD Read" functionalExpression="c0+cp1*(up+exp(up))+cp2*(pow(up,2)+exp(up))+cp3*(pow(up,3)+exp(up))+cr1*(ur+exp(ur))+cr2*(pow(ur,2)+exp(ur))+cr3*(pow(ur,3)+exp(ur))">
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_OLzjkFgGEeaHDMHWpSqWyA3" name="c0"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_O05j4FgGEeaHDMHWpSqWyA3" name="cp1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_PW1zUFgGEeaHDMHWpSqWyA3" name="cp2"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_QJRV0FgGEeaHDMHWpSqWyA3" name="cp3"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_RU6pkFgGEeaHDMHWpSqWyA3" name="cr1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_Tb_q0FgGEeaHDMHWpSqWyA3" name="cr2"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="_UCEzYFgGEeaHDMHWpSqWyA3" name="cr3"/>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_duQk0VgGEeaHDMHWpSqWyA3" name="up">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_QIb6cikUEeSuf8LV7cHLgA"/>
    </consumptionFactors>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="_gvgIQVgGEeaHDMHWpSqWyA3" name="ur">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_dwmeElVcEea-nOJ8YX6eWg"/>
    </consumptionFactors>
  </powerModelSpecifications>
  <powerModelSpecifications xsi:type="de.fzi.power:DeclarativePowerModelSpecification" id="03d67c321bcf4f7b8f05bee6148fc198w" name="bfepm pow exp CPU HDD Write" functionalExpression="c0+cp1*(up+exp(up))+cw1*(uw+exp(uw))">
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="03d67c321bcf4f7b8f05bee6148fc1981w" name="c0"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="03d67c321bcf4f7b8f05bee6148fc1982w" name="cp1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="03d67c321bcf4f7b8f05bee6148fc1986w" name="cw1"/>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="03d67c321bcf4f7b8f05bee6148fc1988w" name="up">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_QIb6cikUEeSuf8LV7cHLgA"/>
    </consumptionFactors>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="03d67c321bcf4f7b8f05bee6148fc1980w" name="uw">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_1Q6twlVcEea-nOJ8YX6eWg"/>
    </consumptionFactors>
  </powerModelSpecifications>
  <powerModelSpecifications xsi:type="de.fzi.power:DeclarativePowerModelSpecification" id="03d67c321bcf4f7b8f05bee6148fc198r" name="bfepm pow exp CPU HDD Read" functionalExpression="c0+cp1*(up+exp(up))+cr1*(ur+exp(ur))">
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="03d67c321bcf4f7b8f05bee6148fc1981r" name="c0"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="03d67c321bcf4f7b8f05bee6148fc1982r" name="cp1"/>
    <consumptionFactors xsi:type="de.fzi.power:FixedFactor" id="03d67c321bcf4f7b8f05bee6148fc1984r" name="cr1"/>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="03d67c321bcf4f7b8f05bee6148fc1988r" name="up">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_QIb6cikUEeSuf8LV7cHLgA"/>
    </consumptionFactors>
    <consumptionFactors xsi:type="de.fzi.power:MeasuredFactor" id="03d67c321bcf4f7b8f05bee6148fc1989r" name="ur">
      <metricType href="pathmap://METRIC_SPEC_MODELS/models/commonMetrics.metricSpec#_dwmeElVcEea-nOJ8YX6eWg"/>
    </consumptionFactors>
  </powerModelSpecifications>
</de.fzi.power:PowerModelRepository>
