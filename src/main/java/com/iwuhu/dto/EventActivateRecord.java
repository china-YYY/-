package com.iwuhu.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Builder
@Data
@AllArgsConstructor
public class EventActivateRecord {
    private Integer eventId;
    private String eventExpression;
    private String domainId;
    private String orgHierarchyCode;
    private Long activateTimestamp;
    private Date activateDateTime;
    private List<EventActivateRecordFactor> factorList;

    // public EventActivateRecord(Integer eventId, String eventExpression, String domainId, String orgHierarchyCode, Long activateTimestamp, List<EventActivateRecordFactor> factorList) {
    //     this.eventId = eventId;
    //     this.eventExpression = eventExpression;
    //     this.domainId = domainId;
    //     this.orgHierarchyCode = orgHierarchyCode;
    //     this.activateTimestamp = activateTimestamp;
    //     this.activateDateTime = new Date(activateTimestamp);
    //     this.factorList = factorList;
    // }
}
