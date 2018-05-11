package com.example.controller;

import com.example.contants.Contants;
import com.example.model.QqSinger;
import com.example.model.QqSpecial;
import com.example.service.AlbumService;
import com.example.service.SingerService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class ShowController {
    @Autowired
    private SingerService singerservice;
    @Autowired
    private AlbumService albumService;
    private PageInfo<QqSinger> info;
    private PageInfo<QqSpecial> info2;


    @RequestMapping("/singers")
    public ModelAndView singers(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("singerlist");
        info = singerservice.selQqSinger(4, 1);
        mav.addObject("singerPage", info);
        mav.addObject("message", "Hello Spring MVC");
        return mav;
    }
    @RequestMapping("/albums")
    public ModelAndView albums(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("albumlist");
        QqSpecial special = new QqSpecial();
        special.setGroupId(Contants.Goroup_Album);
        info2 = albumService.selSpecial(4,1,special);
        mav.addObject("albumPage", info2);
        mav.addObject("message", "Hello Spring MVC");
        return mav;
    }
}
