package com.solstice.courseservice;

public class CourseInfo {

    public final String id;
    public final String name;
    public final String tags;

    public CourseInfo(String id, String name, String tags) {
        this.id = id;
        this.name = name;
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (o.getClass() != this.getClass()) {
            return false;
        }

        CourseInfo rhs = (CourseInfo)o;
        return this.id.equals(rhs.id) &&
                this.name.equals(rhs.name) &&
                this.tags.equals(rhs.tags);
    }

    @Override
    public int hashCode() {
        return super.hashCode() +
                this.id.hashCode() +
                this.name.hashCode() +
                this.tags.hashCode();
    }

}
