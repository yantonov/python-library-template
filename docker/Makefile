help:
	@cat Makefile

DOCKER_FILE=Dockerfile
SRC?=$(shell pwd)
CONTAINER_DIR=/workspace
PROJECT_DIR?=new-awesome-project

IMAGE=yantonov/python-library-template

build:
	docker build \
		-t $(IMAGE) \
		-f $(DOCKER_FILE) .

run:
	docker run \
			-i -t \
			-v "$(SRC):$(CONTAINER_DIR)" \
			--rm \
			"$(IMAGE)" \
			lein new python-library "$(PROJECT_DIR)"

ssh:
	docker run --rm -t -i -v "$(SRC):$(CONTAINER_DIR)" "$(IMAGE)" /bin/bash

stop:
	docker stop "$(shell docker ps -a --filter "ancestor=$(IMAGE)" --format '{{.ID}}' | head -n 1 || echo "")"

pull:
	docker pull "$(IMAGE)"

uninstall:
	docker image rm "$(IMAGE)"
