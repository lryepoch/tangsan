package com.simple.qa.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuestionsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QuestionsExample() {
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andQDescIsNull() {
            addCriterion("q_desc is null");
            return (Criteria) this;
        }

        public Criteria andQDescIsNotNull() {
            addCriterion("q_desc is not null");
            return (Criteria) this;
        }

        public Criteria andQDescEqualTo(String value) {
            addCriterion("q_desc =", value, "qDesc");
            return (Criteria) this;
        }

        public Criteria andQDescNotEqualTo(String value) {
            addCriterion("q_desc <>", value, "qDesc");
            return (Criteria) this;
        }

        public Criteria andQDescGreaterThan(String value) {
            addCriterion("q_desc >", value, "qDesc");
            return (Criteria) this;
        }

        public Criteria andQDescGreaterThanOrEqualTo(String value) {
            addCriterion("q_desc >=", value, "qDesc");
            return (Criteria) this;
        }

        public Criteria andQDescLessThan(String value) {
            addCriterion("q_desc <", value, "qDesc");
            return (Criteria) this;
        }

        public Criteria andQDescLessThanOrEqualTo(String value) {
            addCriterion("q_desc <=", value, "qDesc");
            return (Criteria) this;
        }

        public Criteria andQDescLike(String value) {
            addCriterion("q_desc like", value, "qDesc");
            return (Criteria) this;
        }

        public Criteria andQDescNotLike(String value) {
            addCriterion("q_desc not like", value, "qDesc");
            return (Criteria) this;
        }

        public Criteria andQDescIn(List<String> values) {
            addCriterion("q_desc in", values, "qDesc");
            return (Criteria) this;
        }

        public Criteria andQDescNotIn(List<String> values) {
            addCriterion("q_desc not in", values, "qDesc");
            return (Criteria) this;
        }

        public Criteria andQDescBetween(String value1, String value2) {
            addCriterion("q_desc between", value1, value2, "qDesc");
            return (Criteria) this;
        }

        public Criteria andQDescNotBetween(String value1, String value2) {
            addCriterion("q_desc not between", value1, value2, "qDesc");
            return (Criteria) this;
        }

        public Criteria andQTimeIsNull() {
            addCriterion("q_time is null");
            return (Criteria) this;
        }

        public Criteria andQTimeIsNotNull() {
            addCriterion("q_time is not null");
            return (Criteria) this;
        }

        public Criteria andQTimeEqualTo(Date value) {
            addCriterion("q_time =", value, "qTime");
            return (Criteria) this;
        }

        public Criteria andQTimeNotEqualTo(Date value) {
            addCriterion("q_time <>", value, "qTime");
            return (Criteria) this;
        }

        public Criteria andQTimeGreaterThan(Date value) {
            addCriterion("q_time >", value, "qTime");
            return (Criteria) this;
        }

        public Criteria andQTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("q_time >=", value, "qTime");
            return (Criteria) this;
        }

        public Criteria andQTimeLessThan(Date value) {
            addCriterion("q_time <", value, "qTime");
            return (Criteria) this;
        }

        public Criteria andQTimeLessThanOrEqualTo(Date value) {
            addCriterion("q_time <=", value, "qTime");
            return (Criteria) this;
        }

        public Criteria andQTimeIn(List<Date> values) {
            addCriterion("q_time in", values, "qTime");
            return (Criteria) this;
        }

        public Criteria andQTimeNotIn(List<Date> values) {
            addCriterion("q_time not in", values, "qTime");
            return (Criteria) this;
        }

        public Criteria andQTimeBetween(Date value1, Date value2) {
            addCriterion("q_time between", value1, value2, "qTime");
            return (Criteria) this;
        }

        public Criteria andQTimeNotBetween(Date value1, Date value2) {
            addCriterion("q_time not between", value1, value2, "qTime");
            return (Criteria) this;
        }

        public Criteria andANumIsNull() {
            addCriterion("a_num is null");
            return (Criteria) this;
        }

        public Criteria andANumIsNotNull() {
            addCriterion("a_num is not null");
            return (Criteria) this;
        }

        public Criteria andANumEqualTo(Integer value) {
            addCriterion("a_num =", value, "aNum");
            return (Criteria) this;
        }

        public Criteria andANumNotEqualTo(Integer value) {
            addCriterion("a_num <>", value, "aNum");
            return (Criteria) this;
        }

        public Criteria andANumGreaterThan(Integer value) {
            addCriterion("a_num >", value, "aNum");
            return (Criteria) this;
        }

        public Criteria andANumGreaterThanOrEqualTo(Integer value) {
            addCriterion("a_num >=", value, "aNum");
            return (Criteria) this;
        }

        public Criteria andANumLessThan(Integer value) {
            addCriterion("a_num <", value, "aNum");
            return (Criteria) this;
        }

        public Criteria andANumLessThanOrEqualTo(Integer value) {
            addCriterion("a_num <=", value, "aNum");
            return (Criteria) this;
        }

        public Criteria andANumIn(List<Integer> values) {
            addCriterion("a_num in", values, "aNum");
            return (Criteria) this;
        }

        public Criteria andANumNotIn(List<Integer> values) {
            addCriterion("a_num not in", values, "aNum");
            return (Criteria) this;
        }

        public Criteria andANumBetween(Integer value1, Integer value2) {
            addCriterion("a_num between", value1, value2, "aNum");
            return (Criteria) this;
        }

        public Criteria andANumNotBetween(Integer value1, Integer value2) {
            addCriterion("a_num not between", value1, value2, "aNum");
            return (Criteria) this;
        }

        public Criteria andLabelIsNull() {
            addCriterion("label is null");
            return (Criteria) this;
        }

        public Criteria andLabelIsNotNull() {
            addCriterion("label is not null");
            return (Criteria) this;
        }

        public Criteria andLabelEqualTo(String value) {
            addCriterion("label =", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelNotEqualTo(String value) {
            addCriterion("label <>", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelGreaterThan(String value) {
            addCriterion("label >", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelGreaterThanOrEqualTo(String value) {
            addCriterion("label >=", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelLessThan(String value) {
            addCriterion("label <", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelLessThanOrEqualTo(String value) {
            addCriterion("label <=", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelLike(String value) {
            addCriterion("label like", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelNotLike(String value) {
            addCriterion("label not like", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelIn(List<String> values) {
            addCriterion("label in", values, "label");
            return (Criteria) this;
        }

        public Criteria andLabelNotIn(List<String> values) {
            addCriterion("label not in", values, "label");
            return (Criteria) this;
        }

        public Criteria andLabelBetween(String value1, String value2) {
            addCriterion("label between", value1, value2, "label");
            return (Criteria) this;
        }

        public Criteria andLabelNotBetween(String value1, String value2) {
            addCriterion("label not between", value1, value2, "label");
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