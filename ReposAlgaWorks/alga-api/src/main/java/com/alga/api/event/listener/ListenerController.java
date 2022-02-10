package com.alga.api.event.listener;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.alga.api.event.EventController;

@Component
public abstract class ListenerController implements ApplicationListener<EventController> {

	@Override
	public void onApplicationEvent(EventController eventController) {
		HttpServletResponse response = eventController.getResponse();
		Long codigo = eventController.getCodigo();
		URI uri = ServletUriComponentsBuilder.fromCurrentServletMapping().path("/codigo").buildAndExpand(codigo)
				.toUri();
		response.setHeader("Location", uri.toASCIIString());
	}

}
