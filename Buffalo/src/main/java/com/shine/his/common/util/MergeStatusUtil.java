package com.shine.his.common.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by claude on 15-7-13.
 */
public class MergeStatusUtil {
    /**
     * 整合状态工具,用于整合前段传输的list和后台已经存入的
     * list做对比,然后根据对比后的状态做对应的数据库操作.
     * 对比原理:
     * 前段数据中有id的是作为更新状态处理.
     * 前段数据中没有id的作为新增处理.
     * 后台数据中没有在前段list中的数据作为删除处理.
     *
     * @param newList        前段传输的新的list
     * @param persistentList 后台数据库查询的list
     * @return
     */
    public static List<MergedEntity> mergeStatus(List<Mergeable> newList, List<Mergeable> persistentList) {
        MergedEntity entity = null;
        List<MergedEntity> list = new ArrayList<>();
        if (newList != null) {
            for (Mergeable merge : newList) {
                entity = new MergedEntity();
                entity.setEntity(merge);
                if (merge.getId() != null) {
                    entity.setStatus(CommonStatus.UPDATE);
                } else {
                    entity.setStatus(CommonStatus.NEW);
                }
                list.add(entity);
            }
        }

        if (persistentList != null) {
            persistentList.stream().filter(merge -> !newList.contains(merge)).forEach(merge -> list.add(new MergedEntity(merge, CommonStatus.DELETE)));
        }
        return list;
    }

    public static boolean isNew(MergedEntity entity) {
        return CommonStatus.NEW.equals(entity.getStatus());
    }

    public static boolean isDelete(MergedEntity entity) {
        return CommonStatus.DELETE.equals(entity.getStatus());
    }

    public static boolean isUpdate(MergedEntity entity) {
        return CommonStatus.UPDATE.equals(entity.getStatus());
    }

    public enum CommonStatus {
        UPDATE(), NEW(), DELETE();

        @Override
        public String toString() {
            return "CommonStatus[" + this.name() + "]";
        }
    }

    public interface Mergeable {
        Object getId();
    }

    public static class MergedEntity<T> {
        private T entity;
        private CommonStatus status;

        public MergedEntity() {
        }

        public MergedEntity(T entity, CommonStatus status) {
            this.entity = entity;
            this.status = status;
        }

        public T getEntity() {
            return entity;
        }

        public void setEntity(T entity) {
            this.entity = entity;
        }

        public CommonStatus getStatus() {
            return status;
        }

        public void setStatus(CommonStatus status) {
            this.status = status;
        }
    }
}
