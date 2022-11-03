package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
// @Generated("jsonschema2pojo")
public class ReqResPojo {

    // @SerializedName("name")
    // @Expose
    private String name;

    // @SerializedName("job")
    // @Expose
    private String job;

    // @SerializedName("id")
    // @Expose
    private String id;
    
    // @SerializedName("createdAt")
    // @Expose
    private String createdAt;

   

    // @Override
    // public String toString() {
    //     StringBuilder sb = new StringBuilder();
    //     sb.append(ReqResPojo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
    //     sb.append("name");
    //     sb.append('=');
    //     sb.append(((this.name == null)?"<null>":this.name));
    //     sb.append(',');
    //     sb.append("job");
    //     sb.append('=');
    //     sb.append(((this.job == null)?"<null>":this.job));
    //     sb.append(',');
    //     if (sb.charAt((sb.length()- 1)) == ',') {
    //         sb.setCharAt((sb.length()- 1), ']');
    //     } else {
    //         sb.append(']');
    //     }
    //     return sb.toString();
    // }

    // @Override
    // public int hashCode() {
    //     int result = 1;
    //     result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
    //     result = ((result* 31)+((this.job == null)? 0 :this.job.hashCode()));
    //     return result;
    // }

    // @Override
    // public boolean equals(Object other) {
    //     if (other == this) {
    //         return true;
    //     }
    //     if ((other instanceof ReqResPojo) == false) {
    //         return false;
    //     }
    //     ReqResPojo rhs = ((ReqResPojo) other);
    //     return (((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name)))&&((this.job == rhs.job)||((this.job!= null)&&this.job.equals(rhs.job))));
    // }

}