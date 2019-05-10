package com.daoliuhe.monitor.model;

import org.springframework.util.StringUtils;

public class Health {

    private String environment;
    private String url;
    private String style;

    private String cluster_name;
    private String status;
    private boolean timed_out;
    private int number_of_nodes;
    private int number_of_data_nodes;
    private int active_primary_shards;
    private int active_shards;
    private int relocating_shards;
    private int initializing_shards;
    private int unassigned_shards;
    private int delayed_unassigned_shards;
    private int number_of_pending_tasks;
    private int number_of_in_flight_fetch;
    private int task_max_waiting_in_queue_millis;
    private int active_shards_percent_as_number;

    public String getCluster_name() {
        return cluster_name;
    }

    public void setCluster_name(String cluster_name) {
        this.cluster_name = cluster_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isTimed_out() {
        return timed_out;
    }

    public void setTimed_out(boolean timed_out) {
        this.timed_out = timed_out;
    }

    public int getNumber_of_nodes() {
        return number_of_nodes;
    }

    public void setNumber_of_nodes(int number_of_nodes) {
        this.number_of_nodes = number_of_nodes;
    }

    public int getNumber_of_data_nodes() {
        return number_of_data_nodes;
    }

    public void setNumber_of_data_nodes(int number_of_data_nodes) {
        this.number_of_data_nodes = number_of_data_nodes;
    }

    public int getActive_primary_shards() {
        return active_primary_shards;
    }

    public void setActive_primary_shards(int active_primary_shards) {
        this.active_primary_shards = active_primary_shards;
    }

    public int getActive_shards() {
        return active_shards;
    }

    public void setActive_shards(int active_shards) {
        this.active_shards = active_shards;
    }

    public int getRelocating_shards() {
        return relocating_shards;
    }

    public void setRelocating_shards(int relocating_shards) {
        this.relocating_shards = relocating_shards;
    }

    public int getInitializing_shards() {
        return initializing_shards;
    }

    public void setInitializing_shards(int initializing_shards) {
        this.initializing_shards = initializing_shards;
    }

    public int getUnassigned_shards() {
        return unassigned_shards;
    }

    public void setUnassigned_shards(int unassigned_shards) {
        this.unassigned_shards = unassigned_shards;
    }

    public int getDelayed_unassigned_shards() {
        return delayed_unassigned_shards;
    }

    public void setDelayed_unassigned_shards(int delayed_unassigned_shards) {
        this.delayed_unassigned_shards = delayed_unassigned_shards;
    }

    public int getNumber_of_pending_tasks() {
        return number_of_pending_tasks;
    }

    public void setNumber_of_pending_tasks(int number_of_pending_tasks) {
        this.number_of_pending_tasks = number_of_pending_tasks;
    }

    public int getNumber_of_in_flight_fetch() {
        return number_of_in_flight_fetch;
    }

    public void setNumber_of_in_flight_fetch(int number_of_in_flight_fetch) {
        this.number_of_in_flight_fetch = number_of_in_flight_fetch;
    }

    public int getTask_max_waiting_in_queue_millis() {
        return task_max_waiting_in_queue_millis;
    }

    public void setTask_max_waiting_in_queue_millis(int task_max_waiting_in_queue_millis) {
        this.task_max_waiting_in_queue_millis = task_max_waiting_in_queue_millis;
    }

    public int getActive_shards_percent_as_number() {
        return active_shards_percent_as_number;
    }

    public void setActive_shards_percent_as_number(int active_shards_percent_as_number) {
        this.active_shards_percent_as_number = active_shards_percent_as_number;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @Override
    public String toString() {
        return "Health{" +
                "environment='" + environment + '\'' +
                ", url='" + url + '\'' +
                ", style='" + style + '\'' +
                ", cluster_name='" + cluster_name + '\'' +
                ", status='" + status + '\'' +
                ", timed_out=" + timed_out +
                ", number_of_nodes=" + number_of_nodes +
                ", number_of_data_nodes=" + number_of_data_nodes +
                ", active_primary_shards=" + active_primary_shards +
                ", active_shards=" + active_shards +
                ", relocating_shards=" + relocating_shards +
                ", initializing_shards=" + initializing_shards +
                ", unassigned_shards=" + unassigned_shards +
                ", delayed_unassigned_shards=" + delayed_unassigned_shards +
                ", number_of_pending_tasks=" + number_of_pending_tasks +
                ", number_of_in_flight_fetch=" + number_of_in_flight_fetch +
                ", task_max_waiting_in_queue_millis=" + task_max_waiting_in_queue_millis +
                ", active_shards_percent_as_number=" + active_shards_percent_as_number +
                '}';
    }
}
