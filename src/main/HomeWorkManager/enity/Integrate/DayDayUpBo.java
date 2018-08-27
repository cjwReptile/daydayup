package HomeWorkManager.enity.Integrate;

import HomeWorkManager.dto.IntegrateScoreDto;

import java.util.Map;

/**
 * @Auther: cjw
 * @Date: 2018/8/12 22:57
 * @Description:
 */
public class DayDayUpBo {

    private Map<String,Object> dataMap;

    private String teaBelong;

    private String time;

    private IntegrateScoreDto dto;

    public Map<String, Object> getDataMap() {
        return dataMap;
    }

    public void setDataMap(Map<String, Object> dataMap) {
        this.dataMap = dataMap;
    }

    public String getTeaBelong() {
        return teaBelong;
    }

    public void setTeaBelong(String teaBelong) {
        this.teaBelong = teaBelong;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public IntegrateScoreDto getDto() {
        return dto;
    }

    public void setDto(IntegrateScoreDto dto) {
        this.dto = dto;
    }
}
