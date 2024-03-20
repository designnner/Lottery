package cn.wdx.lottery.interfaces.assembler;

import cn.wdx.lottery.domain.strategy.model.vo.DrawAwardInfo;
import cn.wdx.lottery.rpc.dto.AwardDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;


/*
 * @author: wdxxx
 * @description:  TODO
 * @date:    2024/3/13$ 4:23 PM$
 * @github: https://github.com/designnner
 */
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE,unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface AwardMapping extends IMapping<DrawAwardInfo, AwardDTO> {

    @Mapping(target = "userId" ,source = "uId")
    @Override
    AwardDTO sourceToTarget(DrawAwardInfo var1);

    @Override
    DrawAwardInfo targetToSource(AwardDTO var1);
}
