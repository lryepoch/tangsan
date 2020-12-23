package com.simple.qa.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnswersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AnswersExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andAIdIsNull() {
            addCriterion("a_id is null");
            return (Criteria) this;
        }

        public Criteria andAIdIsNotNull() {
            addCriterion("a_id is not null");
            return (Criteria) this;
        }

        public Criteria andAIdEqualTo(Integer value) {
            addCriterion("a_id =", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdNotEqualTo(Integer value) {
            addCriterion("a_id <>", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdGreaterThan(Integer value) {
            addCriterion("a_id >", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("a_id >=", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdLessThan(Integer value) {
            addCriterion("a_id <", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdLessThanOrEqualTo(Integer value) {
            addCriterion("a_id <=", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdIn(List<Integer> values) {
            addCriterion("a_id in", values, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdNotIn(List<Integer> values) {
            addCriterion("a_id not in", values, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdBetween(Integer value1, Integer value2) {
            addCriterion("a_id between", value1, value2, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdNotBetween(Integer value1, Integer value2) {
            addCriterion("a_id not between", value1, value2, "aId");
            return (Criteria) this;
        }

        public Criteria andAContentIsNull() {
            addCriterion("a_content is null");
            return (Criteria) this;
        }

        public Criteria andAContentIsNotNull() {
            addCriterion("a_content is not null");
            return (Criteria) this;
        }

        public Criteria andAContentEqualTo(String value) {
            addCriterion("a_content =", value, "aContent");
            return (Criteria) this;
        }

        public Criteria andAContentNotEqualTo(String value) {
            addCriterion("a_content <>", value, "aContent");
            return (Criteria) this;
        }

        public Criteria andAContentGreaterThan(String value) {
            addCriterion("a_content >", value, "aContent");
            return (Criteria) this;
        }

        public Criteria andAContentGreaterThanOrEqualTo(String value) {
            addCriterion("a_content >=", value, "aContent");
            return (Criteria) this;
        }

        public Criteria andAContentLessThan(String value) {
            addCriterion("a_content <", value, "aContent");
            return (Criteria) this;
        }

        public Criteria andAContentLessThanOrEqualTo(String value) {
            addCriterion("a_content <=", value, "aContent");
            return (Criteria) this;
        }

        public Criteria andAContentLike(String value) {
            addCriterion("a_content like", value, "aContent");
            return (Criteria) this;
        }

        public Criteria andAContentNotLike(String value) {
            addCriterion("a_content not like", value, "aContent");
            return (Criteria) this;
        }

        public Criteria andAContentIn(List<String> values) {
            addCriterion("a_content in", values, "aContent");
            return (Criteria) this;
        }

        public Criteria andAContentNotIn(List<String> values) {
            addCriterion("a_content not in", values, "aContent");
            return (Criteria) this;
        }

        public Criteria andAContentBetween(String value1, String value2) {
            addCriterion("a_content between", value1, value2, "aContent");
            return (Criteria) this;
        }

        public Criteria andAContentNotBetween(String value1, String value2) {
            addCriterion("a_content not between", value1, value2, "aContent");
            return (Criteria) this;
        }

        public Criteria andATimeIsNull() {
            addCriterion("a_time is null");
            return (Criteria) this;
        }

        public Criteria andATimeIsNotNull() {
            addCriterion("a_time is not null");
            return (Criteria) this;
        }

        public Criteria andATimeEqualTo(Date value) {
            addCriterion("a_time =", value, "aTime");
            return (Criteria) this;
        }

        public Criteria andATimeNotEqualTo(Date value) {
            addCriterion("a_time <>", value, "aTime");
            return (Criteria) this;
        }

        public Criteria andATimeGreaterThan(Date value) {
            addCriterion("a_time >", value, "aTime");
            return (Criteria) this;
        }

        public Criteria andATimeGreaterThanOrEqualTo(Date value) {
            addCriterion("a_time >=", value, "aTime");
            return (Criteria) this;
        }

        public Criteria andATimeLessThan(Date value) {
            addCriterion("a_time <", value, "aTime");
            return (Criteria) this;
        }

        public Criteria andATimeLessThanOrEqualTo(Date value) {
            addCriterion("a_time <=", value, "aTime");
            return (Criteria) this;
        }

        public Criteria andATimeIn(List<Date> values) {
            addCriterion("a_time in", values, "aTime");
            return (Criteria) this;
        }

        public Criteria andATimeNotIn(List<Date> values) {
            addCriterion("a_time not in", values, "aTime");
            return (Criteria) this;
        }

        public Criteria andATimeBetween(Date value1, Date value2) {
            addCriterion("a_time between", value1, value2, "aTime");
            return (Criteria) this;
        }

        public Criteria andATimeNotBetween(Date value1, Date value2) {
            addCriterion("a_time not between", value1, value2, "aTime");
            return (Criteria) this;
        }

        public Criteria andQIdIsNull() {
            addCriterion("q_id is null");
            return (Criteria) this;
        }

        public Criteria andQIdIsNotNull() {
            addCriterion("q_id is not null");
            return (Criteria) this;
        }

        public Criteria andQIdEqualTo(Integer value) {
            addCriterion("q_id =", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdNotEqualTo(Integer value) {
            addCriterion("q_id <>", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdGreaterThan(Integer value) {
            addCriterion("q_id >", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("q_id >=", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdLessThan(Integer value) {
            addCriterion("q_id <", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdLessThanOrEqualTo(Integer value) {
            addCriterion("q_id <=", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdIn(List<Integer> values) {
            addCriterion("q_id in", values, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdNotIn(List<Integer> values) {
            addCriterion("q_id not in", values, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdBetween(Integer value1, Integer value2) {
            addCriterion("q_id between", value1, value2, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdNotBetween(Integer value1, Integer value2) {
            addCriterion("q_id not between", value1, value2, "qId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}