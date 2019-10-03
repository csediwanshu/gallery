import { TestBed } from '@angular/core/testing';

import { ViewalbumService } from './viewalbum.service';

describe('ViewalbumService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ViewalbumService = TestBed.get(ViewalbumService);
    expect(service).toBeTruthy();
  });
});
