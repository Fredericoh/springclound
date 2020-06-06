package academy.devdojo.youtube.core.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApplicationUser implements AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @NotBlank(message = "O campo userName é obrigatorio.")
    @Column(nullable = false)
    private String userName;

    @NotBlank(message = "O campo password é obrigatorio.")
    @Column(nullable = false)
    @ToString.Exclude
    private String password;

    @NotBlank(message = "O campo role é obrigatorio.")
    @Column(nullable = false)
    @Builder.Default
    private String role = "USER";

    public ApplicationUser(@NotNull ApplicationUser applicationUser) {
        this.id = applicationUser.getId ();
        this.userName = applicationUser.getUserName ();
        this.password = applicationUser.getPassword ();
        this.role = applicationUser.getRole ();
    }
}
