package com.ssss.smallScaleShiftScheduler.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// MongoDB dokumentum annotáció
@Document(collection = "daily_schedules")
public class DailySchedule {
    @Id
    private String id;

    private LocalDate date;

    private List<ShiftAssignment> shifts = new ArrayList<>();

    private List<DayOffAssignment> dayOffs = new ArrayList<>();

    // Üres konstruktor MongoDB-hez
    public DailySchedule() {}

    public DailySchedule(LocalDate date) {
        this.date = date;
    }

    // Getters & Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<ShiftAssignment> getShifts() {
        return shifts;
    }

    public void setShifts(List<ShiftAssignment> shifts) {
        this.shifts = shifts;
    }

    public List<DayOffAssignment> getDayOffs() {
        return dayOffs;
    }

    public void setDayOffs(List<DayOffAssignment> dayOffs) {
        this.dayOffs = dayOffs;
    }

    // Segédmetódusok
    public void addShift(ShiftAssignment shift) {
        this.shifts.add(shift);
    }

    public void addDayOff(DayOffAssignment dayOff) {
        this.dayOffs.add(dayOff);
    }

    // ShiftAssignment belső statikus osztály
    public static class ShiftAssignment {
        private Long shiftTemplateId;
        private List<Long> assignedEmployeeIds = new ArrayList<>();
        private LocalTime startTime;
        private LocalTime endTime;

        public ShiftAssignment() {}

        public ShiftAssignment(Long shiftTemplateId, LocalTime startTime, LocalTime endTime) {
            this.shiftTemplateId = shiftTemplateId;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public Long getShiftTemplateId() {
            return shiftTemplateId;
        }

        public void setShiftTemplateId(Long shiftTemplateId) {
            this.shiftTemplateId = shiftTemplateId;
        }

        public List<Long> getAssignedEmployeeIds() {
            return assignedEmployeeIds;
        }

        public void setAssignedEmployeeIds(List<Long> assignedEmployeeIds) {
            this.assignedEmployeeIds = assignedEmployeeIds;
        }


        public LocalTime getStartTime() {
            return startTime;
        }

        public void setStartTime(LocalTime startTime) {
            this.startTime = startTime;
        }

        public LocalTime getEndTime() {
            return endTime;
        }

        public void setEndTime(LocalTime endTime) {
            this.endTime = endTime;
        }

        public void addEmployee(Long employeeId) {
            if (!assignedEmployeeIds.contains(employeeId)) {
                assignedEmployeeIds.add(employeeId);
            }
        }

        public void removeEmployee(Long employeeId) {
            assignedEmployeeIds.remove(employeeId);
        }

        public void removeAllEmployees() {
            assignedEmployeeIds.clear();
        }

        public void removeEmployees(List<Long> employeeIds) {
            assignedEmployeeIds.removeAll(employeeIds);
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ShiftAssignment)) return false;
            ShiftAssignment that = (ShiftAssignment) o;
            return Objects.equals(shiftTemplateId, that.shiftTemplateId) &&
                    Objects.equals(assignedEmployeeIds, that.assignedEmployeeIds) &&
                    Objects.equals(startDateTime, that.startDateTime) &&
                    Objects.equals(endDateTime, that.endDateTime);
        }

        @Override
        public int hashCode() {
            return Objects.hash(shiftTemplateId, assignedEmployeeIds, startDateTime, endDateTime);
        }

        // Segéd: dátum + időből LocalDateTime
        public LocalDateTime getStartDateTime(LocalDate date) {
            return LocalDateTime.of(date, startTime);
        }

        public LocalDateTime getEndDateTime(LocalDate date) {
            return LocalDateTime.of(date, endTime);
        }
    }


    // DayOffAssignment belső statikus osztály
    public static class DayOffAssignment {
        private Long employeeId;
        private DayOffType type;

        public DayOffAssignment() {}

        public DayOffAssignment(Long employeeId, DayOffType type) {
            this.employeeId = employeeId;
            this.type = type;
        }

        public Long getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeId(Long employeeId) {
            this.employeeId = employeeId;
        }

        public DayOffType getType() {
            return type;
        }

        public void setType(DayOffType type) {
            this.type = type;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof DayOffAssignment)) return false;
            DayOffAssignment that = (DayOffAssignment) o;
            return Objects.equals(employeeId, that.employeeId) &&
                    type == that.type;
        }

        @Override
        public int hashCode() {
            return Objects.hash(employeeId, type);
        }
    }
}
