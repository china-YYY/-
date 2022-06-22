package com.iwuhu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@Data
@AllArgsConstructor
public class EventActivateRecordFactor {
    private Integer factorId;
    private String expressionKeyName;
    private Map<String, Object> runResult;
    private Date runTime;

    /*public EventActivateRecordFactor(Integer factorId, String expressionKeyName, Map<String, Object> runResult, Date runTime) {
        this.factorId = factorId;
        this.expressionKeyName = expressionKeyName;
        this.runResult = runResult;
        this.runTime = runTime;
    }*/
}
