package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Category;
import com.platzi.market.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    //Aquí estamos mapeando los campos de(source) a(target)
    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active")
    })
    Category toCategory(Categoria categoria);

    //@InheritInverseConfiguration: Esta anotación realiza la configuración inversa, es por eso que ya no necestamos mapear otra vez los datos ya que toCategory ya lo mapeo en @Mappings.
    //@Mapping: Esta anotación mapea el dato de la entidad(Categoria) y como productos no esta en la entidad de dominio hay que excluirla, por eso se mapea y se le asigna ignore = true.
    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);
}
